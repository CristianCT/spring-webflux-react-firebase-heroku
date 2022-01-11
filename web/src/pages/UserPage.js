import React, { useEffect } from 'react'
import { connect } from 'react-redux'
import { useForm } from 'react-hook-form'

import { getUser, update } from '../actions/authActions'

const UserPage = ({
  match,
  dispatch,
  hasErrors,
  loading,
  userId,
  userEmail,
  userName,
  userLastName,
  redirect
}) => {
 
  const { register, handleSubmit } = useForm();

  useEffect(() => {
    dispatch(getUser(userId))
  }, [dispatch, userId])

  const onSubmit = data => {
    dispatch(update({
      name: data.name,
      lastName: data.lastName,
      email: userEmail,
      id: userId
    }));
  };

  return (
    <section>
      <h1 className="titulo-datos">Información de usuario</h1>
      <span>Llene los campos necesarios en caso de que desee actualizar sus datos</span>
      <form onSubmit={handleSubmit(onSubmit)}>
        <h2>Nombre: {userName}</h2>
        <input type="text" {...register("name")} />
        <h2>Apellidos: {userLastName}</h2>
        <input type="text" {...register("lastName")} />
        <h2>Email: {userEmail}</h2>
        <input type="email" value={userEmail}  disabled />
        <button type="submit" className="button">Actualizar datos</button>
      </form>
    </section>
  )
}

const mapStateToProps = state => ({
  loading: state.question.loading,
  hasErrors: state.question.hasErrors,
  redirect: state.question.redirect,
  userId: state.auth.uid,
  userEmail: state.auth.email,
  userName: state.auth.name,
  userLastName: state.auth.lastName
})

export default connect(mapStateToProps)(UserPage)
