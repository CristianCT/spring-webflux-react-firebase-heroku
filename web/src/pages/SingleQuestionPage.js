import React, { useEffect } from 'react'
import { connect } from 'react-redux'

import { fetchQuestion, postVote } from '../actions/questionActions'

import { Question } from '../components/Question'
import { Answer } from '../components/Answer'
import { Link } from 'react-router-dom'

const SingleQuestionPage = ({
  match,
  dispatch,
  question,
  hasErrors,
  loading,
  userId, 
  redirect
}) => {
  const { id } = match.params
  useEffect(() => {
    dispatch(fetchQuestion(id))
  }, [dispatch, id])

  useEffect(() => {
    if (redirect) {
        dispatch(fetchQuestion(question.id))
    }
  }, [redirect, dispatch, question]);

  const voteUp = (vote) => {
    console.log(vote);
    dispatch(postVote({
      answerId: vote.id,
      questionId: vote.questionId,
      userId: userId,
      value: 1
    }));
  }

  const voteDown = (vote) => {
    dispatch(postVote({
      answerId: vote.id,
      questionId: vote.questionId,
      userId: userId,
      value: -1
    }));
  }

  const renderQuestion = () => {
    if (loading.question) return <p>Loading question...</p>
    if (hasErrors.question) return <p>Unable to display question.</p>

    return <Question question={question} />
  }

  const renderAnswers = () => {
    return (question.answers && question.answers.length) ? question.answers.map(answer => (
      <Answer key={answer.id} answer={answer} voteUp={voteUp} voteDown={voteDown}/>
    )) : <p>Empty answer!</p>;
  }

  return (
    <section>
      {renderQuestion()}
      {userId && <Link to={"/answer/" + id} className="button right">
        Reply
      </Link>}

      <h2>Answers</h2>
      {renderAnswers()}
    </section>
  )
}

const mapStateToProps = state => ({
  question: state.question.question,
  loading: state.question.loading,
  hasErrors: state.question.hasErrors,
  redirect: state.question.redirect,
  userId: state.auth.uid
})

export default connect(mapStateToProps)(SingleQuestionPage)
