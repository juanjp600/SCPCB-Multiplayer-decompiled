Function mp_server_pushplayertags%(arg0.mp_player)
    Local local0%
    For local0 = $02 To $04 Step $01
        mp_writeline(arg0\Field34[local0]\Field2)
        If (len(arg0\Field34[local0]\Field2) > $00) Then
            mp_writeline(arg0\Field34[local0]\Field0)
            mp_writefloat(arg0\Field34[local0]\Field3)
            mp_writefloat(arg0\Field34[local0]\Field4)
            mp_writefloat(arg0\Field34[local0]\Field5)
            mp_writeint(arg0\Field34[local0]\Field6)
            mp_writeint(arg0\Field34[local0]\Field7)
        EndIf
    Next
    Return $00
End Function
