Function mp_server_fillcorpsedata%(arg0.mp_playercorpse)
    Local local0%
    mp_writebyte(arg0\Field0)
    mp_writebyte(((arg0\Field12 > $00) + (arg0\Field14 Shl $01)))
    mp_writebyte(arg0\Field9)
    mp_writebyte(arg0\Field3)
    mp_writebyte(arg0\Field4)
    mp_writefloat(entityx(arg0\Field2, $00))
    mp_writefloat(entityy(arg0\Field2, $00))
    mp_writefloat(entityz(arg0\Field2, $00))
    mp_writeshort(convertfloattoshort(entityyaw(arg0\Field2, $00), 10.0))
    mp_writefloat(arg0\Field10)
    If (arg0\Field12 > $00) Then
        For local0 = $00 To $09 Step $01
            If (arg0\Field7[local0] <> Null) Then
                mp_writebyte(arg0\Field7[local0]\Field0)
            Else
                mp_writebyte($00)
            EndIf
        Next
    EndIf
    Return $00
End Function
