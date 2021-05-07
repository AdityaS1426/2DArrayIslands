package com.aditya.twodarray;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class WebController
{
    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @PostMapping("/countIslands")
    public String result(@RequestParam("input_array") String input, @RequestParam("rows") Integer rows, @RequestParam("columns") Integer columns, Model model)
    {
        int[][] parsedInput = parseInput(input, rows, columns);
        CountIslands obj = new CountIslands();
        int islands = obj.countNumberOfIslands(parsedInput);
        model.addAttribute("islands", islands);
        model.addAttribute("input", Arrays.deepToString(parsedInput));
        return "result";
    }

    public int[][] parseInput(String input, Integer rows, Integer columns)
    {
        String[] input_array = input.split("\r\n");
        int[][] twoDArray = new int[rows][columns];
        for (int k = 0; k < input_array.length; k++)
        {
            String[] second_arr = input_array[k].split(",");
            for (var p = 0; p < second_arr.length; p++)
            {
                if (second_arr[p] != "0")
                {
                    twoDArray[k][p] = Integer.parseInt(second_arr[p].trim());
                }
            }
        }
        return twoDArray;
    }
}