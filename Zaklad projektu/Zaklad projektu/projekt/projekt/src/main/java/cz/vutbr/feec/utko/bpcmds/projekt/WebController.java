package cz.vutbr.feec.utko.bpcmds.projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class WebController {

    @Autowired
    private ProjectResourceComponent handler;

    private final static String DASH_DIRECTORY = "C:\\Users\\helen\\Desktop\\projekt (2)\\projekt\\videa\\DASH-BIG_BUCK_BUNNY\\";
    private final static String SUFFIX = "mpd";

    @RequestMapping(value = {"/dash/{file}"}, method = RequestMethod.GET)
    public void streaming(@PathVariable("file") String file, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File STREAM_FILE = null;
        STREAM_FILE = new File(DASH_DIRECTORY + file); // for play big bunny "DASH-BIG_BUCK_BUNNY\\" in path

        request.setAttribute(ProjectResourceComponent.ATTR_FILE, STREAM_FILE);
        handler.handleRequest(request, response);
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    }