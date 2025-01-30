Function mp_server_senddoorsdata%()
    Local local0.mp_player
    Local local1.doors
    For local0 = Each mp_player
        If (local0\Field5 > $01) Then
            mp_writebyte($06)
            mp_writebyte($01)
            For local1 = Each doors
                If ((((local1\Field29 <> Null) Lor (625.0 > distancesquared(entityx(local1\Field2, $01), local0\Field7, entityy(local1\Field2, $01), local0\Field8, entityz(local1\Field2, $01), local0\Field9))) And (local1\Field38 = $00)) <> 0) Then
                    mp_writeshort(local1\Field39)
                    mp_writebyte((Int (((((Float ((((local1\Field6 = $01) + ((local1\Field4 = $01) Shl $01)) + (local1\Field33 Shl $02)) + ((local1\Field34 <> $00) Shl $03))) + (max((Float (local1\Field34 - $01)), 0.0) * 16.0)) + (Float (local1\Field35 Shl $05))) + (Float (local1\Field27 Shl $06))) + (Float ((local1\Field4 = $02) Shl $07)))))
                    mp_writebyte((local1\Field28 + (local1\Field31 Shl $01)))
                EndIf
            Next
            mp_writeshort($00)
            mp_send(local0\Field0, local0\Field1)
        EndIf
    Next
    Return $00
End Function
