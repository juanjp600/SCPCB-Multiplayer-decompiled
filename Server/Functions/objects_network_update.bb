Function objects_network_update%()
    Local local0%
    Local local1.mp_objects
    Local local2$
    Local local3.players
    For local0 = $01 To server\Field11 Step $01
        If (playeroptimize[local0]\Field52 > $FF) Then
            playeroptimize[local0]\Field52 = $01
        EndIf
        If (playeroptimize[local0]\Field49 <> playeroptimize[local0]\Field52) Then
            udp_writebyte($5D)
            udp_writebyte($01)
            udp_writebyte(playeroptimize[local0]\Field52)
            For local1 = Each mp_objects
                If (local1\Field13[playeroptimize[local0]\Field30] = $00) Then
                    If (((0.0 = local1\Field12) Or ((0.0 < local1\Field12) And local1\Field14[playeroptimize[local0]\Field30])) <> 0) Then
                        udp_writebyte(local1\Field1)
                        udp_writeshort(local1\Field0)
                        udp_writefloat(entityx(local1\Field11, $01))
                        udp_writefloat(entityy(local1\Field11, $01))
                        udp_writefloat(entityz(local1\Field11, $01))
                        udp_writeshort(converttoshort(entitypitch(local1\Field11, $01)))
                        udp_writeshort(converttoshort(entityyaw(local1\Field11, $01)))
                        udp_writeshort(converttoshort(entityroll(local1\Field11, $01)))
                        udp_writefloat(entityscalex2(local1\Field11))
                        udp_writeshort((Int animtime(local1\Field11)))
                        udp_writebyte(local1\Field15)
                    EndIf
                EndIf
            Next
            udp_sendmessage(playeroptimize[local0]\Field30)
        EndIf
    Next
    For local1 = Each mp_objects
        local2 = (((((((((((((((((Str entityx(local1\Field11, $01)) + "") + (Str entityy(local1\Field11, $01))) + "") + (Str entityz(local1\Field11, $01))) + "") + (Str entitypitch(local1\Field11, $01))) + "") + (Str entityyaw(local1\Field11, $01))) + "") + (Str entityroll(local1\Field11, $01))) + "") + (Str entityscalex2(local1\Field11))) + "") + (Str animtime(local1\Field11))) + "") + (Str local1\Field15))
        If (local1\Field16 <> local2) Then
            For local3 = Each players
                If (local1\Field13[local3\Field30] = $00) Then
                    If ((local1\Field14[local3\Field30] Or (0.0 = local1\Field12)) <> 0) Then
                        local3\Field52 = (local3\Field52 + $01)
                    EndIf
                EndIf
            Next
        EndIf
        local1\Field16 = local2
    Next
    If (istimedout($01, $3E8) <> 0) Then
        For local1 = Each mp_objects
            If (0.0 < local1\Field12) Then
                For local3 = Each players
                    If (local1\Field12 > entitydistance(local3\Field62, local1\Field11)) Then
                        If (local1\Field14[local3\Field30] = $00) Then
                            local3\Field52 = (local3\Field52 + $01)
                            local1\Field14[local3\Field30] = $01
                        EndIf
                    ElseIf (local1\Field14[local3\Field30] <> 0) Then
                        local3\Field52 = (local3\Field52 + $01)
                        local1\Field14[local3\Field30] = $00
                    EndIf
                Next
            Else
                For local3 = Each players
                    local3\Field52 = (local3\Field52 + $01)
                Next
            EndIf
        Next
    EndIf
    Return $00
End Function
