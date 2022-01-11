import React from 'react'
import { 
    BsFacebook, 
    BsInstagram, 
    BsLinkedin, 
    BsGithub, 
    BsYoutube,
    BsTelephoneFill,
    BsBuilding,
    BsChatRightText
 } from "react-icons/bs"

function Footer() {
    return (
        <footer>
            <div className="footer-head">
                <div><span>Get connected with us on social networks:</span></div>
                <div>
                    <a className="icon-social-network" target="_blank" href="https://www.facebook.com/sofkatech/"><BsFacebook size={30}/></a>
                    <a className="icon-social-network" target="_blank" href="https://www.instagram.com/sofka_technologies/?hl=es"><BsInstagram size={30}/></a>
                    <a className="icon-social-network" target="_blank" href="https://co.linkedin.com/company/sofka-technologies"><BsLinkedin size={30}/></a>
                    <a className="icon-social-network" target="_blank" href="https://github.com/Sofka-XT"><BsGithub size={30}/></a>
                    <a className="icon-social-network" target="_blank" href="https://www.youtube.com/channel/UCa6j2dHRleqQciUHLM1FTRw"><BsYoutube size={30}/></a>
                </div>
            </div>
            

            <div className="footer-body">
                <div>
                    <div className="container-img">
                        <img src="https://www.sofka.com.co/wp-content/uploads/2021/02/Group-35.png" />
                    </div>

                    <div>
                        <h3>Preguntas y Respuestas</h3>
                        <p>
                            El proyecto consiste en un sitio donde podras encontrar preguntas de diferentes personas con sus respectivas respuestas, 
                            de la misma manera podrás escribir tus propias preguntas para que la comunidad te pueda dar una posible respuesta
                        </p>
                    </div>

                    <div>
                        <h3>¿Que se puede hacer?</h3>
                        <p><a href="#!">Listar Preguntas</a></p>
                        <p><a href="#!">Ver Respuestas de preguntas</a></p>
                        <p><a href="#!">Agregar pregunta</a></p>
                        <p><a href="#!">Mucho mas</a></p>
                    </div>               

                    <div>
                        <h3>Contacto</h3>
                        <p><BsBuilding/>        New York, NY 10012, US</p>
                        <p><BsChatRightText/>        info@example.com</p>
                        <p><BsTelephoneFill/>        + 01 234 567 88</p>
                        <p><BsTelephoneFill/>        + 01 234 567 89</p>
                    </div>
                </div>
            </div>
            

            <div className="footer-foot">© 2021 Copyright:<a href="https://www.sofka.com.co/es/inicio/">Sofka</a></div>
            
        </footer>
    )
}

export default Footer
