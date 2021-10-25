import http from "../http-common";
import axios from "axios";

class PhoneDataService {
    getAll(){
        return http.get("/phones/");
    }

    get(id){
        return http.get("/phones/"+id);
    }

    create(data){
        return axios.post("https://localhost:8080/api/phones/",data);
    }

    update(id,data){
        return http.put("/phones/${id}",data);
    }
    delete(id){
        return http.delete("/phones/"+id);
    }
}

export default new PhoneDataService();
