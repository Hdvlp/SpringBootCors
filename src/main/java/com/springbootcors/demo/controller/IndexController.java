package com.springbootcors.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class IndexController {

    @GetMapping("/")
    public String getMethodName() {
        return new String("""
                <!doctype>
                <html><head><meta charset="UTF-8"><style>div{margin:20px}</style></head><body>
                <div>CORS</div>
                <div id="getipv4">GET <a href="http://127.0.0.1:8080">http://127.0.0.1:8080</a>/api</div>
                <div id="postipv4">POST <a href="http://127.0.0.1:8080">http://127.0.0.1:8080</a>/api</div>
                <div id="getlocalhost">GET <a href="http://localhost:8080">http://localhost:8080</a>/api</div>
                <div id="postlocalhost">POST <a href="http://localhost:8080">http://localhost:8080</a>/api</div>
                <div id="getipv6">GET <a href="http://[::1]:8080">http://[::1]:8080</a>/api</div>
                <div id="postipv6">POST <a href="http://[::1]:8080">http://[::1]:8080</a>/api</div>
                <script>
                async function getter(uri, elementId){
                    const responseGet = fetch(uri, { "method": "GET" })
                            .then(response => {
                                if (!response.ok) {
                                    return response.text()
                                        .catch(() => {
                                            throw new Error(response.status);
                                        })
                                        .then(({message}) => {
                                            console.log(message);
                                            throw new Error(message || response.status);
                                        });
                                }
                            return response.text();
                            });

                            
                        const responseGetText = await Promise.resolve(responseGet);
                        

                        const elementGet = document.getElementById(elementId);
                        elementGet.innerHTML = elementGet.innerHTML + "<div>" + responseGetText + "</div>"

                }
                
                async function poster(uri, elementId, body){
                    const responsePost = fetch(uri, { "method": "POST", body: body })
                        .then(response => {
                            if (!response.ok) {
                                return response.text()
                                    .catch(() => {
                                        throw new Error(response.status);
                                    })
                                    .then(({message}) => {
                                        console.log(message);
                                        throw new Error(message || response.status);
                                    });
                            }
                        return response.text();
                        });

                        
                    const responsePostText = await Promise.resolve(responsePost);
                    

                    const elementPost = document.getElementById(elementId);
                    elementPost.innerHTML = elementPost.innerHTML + "<div>" + responsePostText + "</div>"
                }

                async function main(){
                    

                   await getter("http://127.0.0.1:8080/api", "getipv4");
                   await poster("http://127.0.0.1:8080/api", "postipv4", JSON.stringify({"user": "user"}));

                   
                   await getter("http://localhost:8080/api", "getlocalhost");
                   await poster("http://localhost:8080/api", "postlocalhost", JSON.stringify({"user": "user"}));

                   
                   await getter("http://[::1]:8080/api", "getipv6");
                   await poster("http://[::1]:8080/api", "postipv6", JSON.stringify({"user": "user"}));


                }
                main();
                </script>
                </body></html>

                """);
    }
    

}
