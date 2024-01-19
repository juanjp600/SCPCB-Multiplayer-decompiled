Function se_and_lua_returnstring%(arg0$)
    If (currentluastate <> $00) Then
        slua_push_string(currentluastate, arg0)
    Else
        se_returnstring(arg0)
    EndIf
    Return $00
End Function
