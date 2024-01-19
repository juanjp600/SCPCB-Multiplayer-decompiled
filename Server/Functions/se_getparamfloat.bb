Function se_getparamfloat#()
    currentparam = (currentparam + $01)
    Return se_and_lua_tofloatarg((currentparam - $01))
    Return 0.0
End Function
