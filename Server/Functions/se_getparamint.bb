Function se_getparamint%()
    currentparam = (currentparam + $01)
    Return se_and_lua_tointarg((currentparam - $01))
    Return $00
End Function
