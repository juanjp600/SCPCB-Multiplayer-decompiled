Function mp_server_pushplayermodel%(arg0.mp_player)
    Local local0%
    If (arg0 = Null) Then
        Return $00
    EndIf
    mp_writebyte(arg0\Field35\Field17)
    mp_writebyte(arg0\Field35\Field18)
    mp_writefloat(arg0\Field35\Field20)
    mp_writefloat(arg0\Field35\Field19)
    If (arg0\Field4\Field5 <> Null) Then
        mp_server_fillcorpsedata(arg0\Field4\Field5)
    Else
        mp_writebyte($00)
    EndIf
    For local0 = $00 To $09 Step $01
        mp_writebyte(getplayerattachmodel(arg0, local0))
    Next
    Return $00
End Function
