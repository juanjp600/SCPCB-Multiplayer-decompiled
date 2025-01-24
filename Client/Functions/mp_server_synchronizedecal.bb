Function mp_server_synchronizedecal%(arg0.decals, arg1%)
    Local local0.mp_player
    If (((mp_ishoster() = $00) Lor (mp_getsocket() = $00)) <> 0) Then
        Return $00
    EndIf
    For local0 = Each mp_player
        If (local0\Field5 > $01) Then
            mp_writebyte($0B)
            mp_writebyte(arg0\Field2)
            mp_writefloat(entityx(arg0\Field0, $01))
            mp_writefloat(entityy(arg0\Field0, $01))
            mp_writefloat(entityz(arg0\Field0, $01))
            mp_writeshort(convertfloattoshort(entitypitch(arg0\Field0, $01), 10.0))
            mp_writeshort(convertfloattoshort(entityyaw(arg0\Field0, $01), 10.0))
            mp_writeshort(convertfloattoshort(entityroll(arg0\Field0, $01), 10.0))
            mp_writefloat(arg0\Field3)
            mp_writefloat(arg0\Field4)
            mp_writefloat(arg0\Field5)
            mp_writefloat(arg0\Field6)
            mp_writefloat(arg0\Field7)
            mp_writebyte(arg0\Field10)
            mp_writebyte(arg0\Field11)
            mp_writebyte(arg0\Field12)
            mp_writefloat(arg0\Field13)
            mp_writefloat(arg0\Field14)
            mp_writebyte(arg1)
            mp_send(local0\Field0, local0\Field1)
        EndIf
    Next
    Return $00
End Function
