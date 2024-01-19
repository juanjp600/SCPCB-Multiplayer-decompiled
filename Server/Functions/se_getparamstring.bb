Function se_getparamstring$()
    currentparam = (currentparam + $01)
    Return se_and_lua_tostringarg((currentparam - $01))
    Return ""
End Function
