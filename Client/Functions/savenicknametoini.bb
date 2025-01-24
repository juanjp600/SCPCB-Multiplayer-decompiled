Function savenicknametoini%(arg0$)
    iniwritestring(optionfile, "Multiplayer", "Nickname", arg0, $01)
    Return $00
End Function
