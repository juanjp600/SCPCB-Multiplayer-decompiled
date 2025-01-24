Function mp_updateshutdown%()
    If (ue_server\Field10 <> 0) Then
        nullgame($01)
        currsave = Null
        resetinput()
    EndIf
    Return $00
End Function
