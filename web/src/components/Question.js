import React from 'react'
import { Link } from 'react-router-dom'
import { BsEmojiFrown, BsEmojiSmile, BsEmojiLaughing } from 'react-icons/bs'

export const Question = ({ question, excerpt, onDelete, showEmogies, qualifyQuestion }) => (
  <article className={excerpt ? 'question-excerpt' : 'question'}>
    <div className="header-question" >
      <h2>{question.question}</h2>
      {
        showEmogies && 
        <div>
          <div>
            <button type="button" onClick={() => qualifyQuestion({questionId: question.id, value: 3})} ><BsEmojiLaughing size={35} /></button>
            <button type="button" onClick={() => qualifyQuestion({questionId: question.id, value: 2})} ><BsEmojiSmile size={35} /></button>
            <button type="button" onClick={() => qualifyQuestion({questionId: question.id, value: 1})} ><BsEmojiFrown size={35} /></button>
          </div>
          <div>
            <p>Promedio: {question.qualification>1.33?"Feliz":question.qualification>0.67?"Satisfecho":"Triste"}</p>
          </div>
        </div>
      }
    </div>
    <p>{question.category}  - <small>{question.type}</small></p>
   
    {onDelete && (
      <button className="button right" onClick={() => onDelete(question.id)}>DELETE</button>
    )}
    {excerpt && (
      <Link to={`/question/${question.id}`} className="button">
        View Question
      </Link>
    )}
  </article>
)
