Function se_and_lua_returnfloat%(arg0#)
    If (currentluastate <> $00) Then
        slua_push_number(currentluastate, arg0)
    Else
        se_returnfloat(arg0)
    EndIf
    Return $00
End Function
