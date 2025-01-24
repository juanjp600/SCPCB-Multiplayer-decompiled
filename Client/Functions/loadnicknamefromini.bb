Function loadnicknamefromini$()
    Return inigetstring(optionfile, "Multiplayer", "Nickname", "Player", $01)
    Return ""
End Function
