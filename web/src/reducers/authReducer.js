import * as actions from '../actions/authActions'

export const initialState = {
  name: null,
  lastname: null,
  email: null,
  uid: null
}

export default function authReducer(state = initialState, action) {
  switch (action.type) {
    case actions.LOGIN:
      const payload = action.payload;
      return {email: payload.email, uid: payload.uid, name: payload.name, lastName: payload.lastName }
    case actions.LOGOUT:
      return initialState
    case actions.UPDATE:
      return {email: payload.email, uid: payload.uid, name: payload.name, lastName: payload.lastName}
    default:
      return state
  }
}
