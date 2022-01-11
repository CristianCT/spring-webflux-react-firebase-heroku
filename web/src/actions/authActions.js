const URL_BASE = 'http://localhost:8080';

export const LOGIN = 'LOGIN'
export const LOGOUT = 'LOGOUT'
export const UPDATE = 'UPDATE'
export const LOADING = 'LOADING'
export const LOADED_SUCCESS = 'LOADED_SUCCESS'
export const LOADED_FAILURE = 'LOADED_FAILURE'

export const loading = () => ({ type: LOADING })

export const success = payload => ({
    type: LOGIN,
    payload
});

export const failure = () => ({ type: LOADED_FAILURE })




//export const login = (email, uid, name, lastName) => ({ type: LOGIN, payload: {email, uid, name, lastName} })

export const logout = () => ({
    type: LOGOUT
});

export function getUser (id){
    return async dispatch => {
        dispatch(loading())
        try {
            const response = await fetch(
                `${URL_BASE}/getUser/${id}`
            )
            const data = await response.json()
            dispatch(success({ email: data.email, uid: data.id, name: data.name, lastName: data.lastName } ))
        } catch (error) {
            dispatch(failure())
        }
    }
};

export function update (user){
    return async dispatch => {
        dispatch(loading())
        try {
            const response = await fetch(
                `${URL_BASE}/saveUser`,
                {
                    method: 'POST',
                    mode: 'cors',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(user)
                }
            )
            const data = await response.json()
            dispatch(success({ email: data.email, uid: data.id, name: data.name, lastName: data.lastName } ))
        } catch (error) {
            dispatch(failure())
        }
    }
};

export function login (user){
    return async dispatch => {
        dispatch(loading())
        try {
            const response = await fetch(
                `${URL_BASE}/login`,
                {
                    method: 'POST',
                    mode: 'cors',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(user)
                }
            )
            const data = await response.json()
            dispatch(success({ email: data.email, uid: data.id, name: data.name, lastName: data.lastName } ))
        } catch (error) {
            dispatch(failure())
        }
    }
};



