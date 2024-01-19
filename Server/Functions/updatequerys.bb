Function updatequerys%()
    Local local0.querys
    Local local1%
    For local0 = Each querys
        If (((local0\Field1 = (local0\Field2 + $01)) Or (player[local0\Field3] = Null)) <> 0) Then
            If (getscripts() <> 0) Then
                public_inqueue($31, $00)
                public_addparam($00, (Str local0\Field3), $01)
                public_addparam($00, local0\Field0, $03)
                public_addparam($00, (Str (player[local0\Field3] <> Null)), $01)
                callback($00)
            EndIf
            If (strippath(local0\Field0) = strippath(server\Field46)) Then
                If (player[local0\Field3] <> Null) Then
                    player[local0\Field3]\Field74 = $01
                EndIf
            EndIf
            closefile(local0\Field5)
            Delete local0
        ElseIf (((server\Field9 = $00) Or ((player[local0\Field3]\Field22 = $01) Or (player[local0\Field3]\Field74 = $00))) <> 0) Then
            If (local0\Field7 < millisecs()) Then
                If (local0\Field1 < local0\Field2) Then
                    resizebank(query_global_data, local0\Field4)
                    seekfile(local0\Field5, local0\Field1)
                    resizebank(query_global_data, (Int min((Float local0\Field4), (Float (local0\Field2 - filepos(local0\Field5))))))
                    readbytes(query_global_data, local0\Field5, $00, banksize(query_global_data))
                    For local1 = $01 To $02 Step $01
                        udp_writebyte($70)
                        udp_writebyte($01)
                        udp_writeline(local0\Field0)
                        udp_writeint((Handle local0))
                        udp_writeint(local0\Field1)
                        udp_writeint(local0\Field2)
                        udp_writebytes(query_global_data, $00, banksize(query_global_data))
                        udp_writebyte(local0\Field6)
                        udp_writeint(local0\Field8)
                        udp_sendmessage(local0\Field3)
                    Next
                    local0\Field1 = (Int min((Float (local0\Field1 + local0\Field4)), (Float local0\Field2)))
                    local0\Field7 = (millisecs() + $14)
                Else
                    udp_writebyte($70)
                    udp_writebyte($01)
                    udp_writeline(local0\Field0)
                    udp_writeint((Handle local0))
                    udp_writeint(local0\Field1)
                    udp_writeint(local0\Field2)
                    udp_writebyte(local0\Field6)
                    udp_writeint(local0\Field8)
                    udp_sendmessage(local0\Field3)
                    local0\Field7 = (millisecs() + $1F4)
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
