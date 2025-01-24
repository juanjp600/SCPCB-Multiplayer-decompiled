Function mp_server_senditemsdata%()
    Local local0.mp_player
    Local local1.items
    Local local3%
    Local local4%
    For local0 = Each mp_player
        If (local0\Field5 > $01) Then
            mp_writebyte($06)
            mp_writebyte($02)
            For local1 = Each items
                If (((local1\Field26 = $00) And ((local1\Field27 = local0\Field5) Lor ((144.0 > entitydistancesquared(local0\Field18, local1\Field2)) And ((local1\Field15 = $00) Lor local1\Field29)))) <> 0) Then
                    mp_writeshort(local1\Field19)
                    mp_writeint(local1\Field4\Field21)
                    mp_writebyte(local1\Field27)
                    Select local1\Field25
                        Case $01
                            mp_writeline(local1\Field1)
                            mp_writeline(local1\Field0)
                            mp_writebyte(local1\Field6)
                            mp_writebyte(local1\Field7)
                            mp_writebyte(local1\Field8)
                            mp_writebyte(convertfloattobyte(local1\Field9, 100.0))
                            mp_writeshort((Int min((Float (Int local1\Field12)), 65535.0)))
                        Case $02
                            If (local1\Field27 = local0\Field5) Then
                                For local3 = $00 To (local1\Field20 - $01) Step $01
                                    If (local1\Field18[local3] <> Null) Then
                                        mp_writeshort(local1\Field18[local3]\Field19)
                                        mp_writeint(local1\Field18[local3]\Field4\Field21)
                                    EndIf
                                Next
                                mp_writeshort($00)
                            Else
                                mp_writebyte(mp_issecondinvempty(local1))
                            EndIf
                        Case $03,$05
                            If (local1\Field27 = local0\Field5) Then
                                mp_writeshort((Int local1\Field12))
                            EndIf
                        Case $04
                            mp_writebyte((Int animtime(local1\Field3)))
                    End Select
                    If (local1\Field27 = $00) Then
                        mp_writefloat(entityx(local1\Field2, $00))
                        mp_writefloat(entityy(local1\Field2, $00))
                        mp_writefloat(entityz(local1\Field2, $00))
                    EndIf
                EndIf
            Next
            mp_writeshort($00)
            mp_send(local0\Field0, local0\Field1)
        EndIf
    Next
    Return $00
End Function
