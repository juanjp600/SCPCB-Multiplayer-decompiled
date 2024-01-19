Function multiplayer_writemiscellaneous%(arg0%)
    Local local0%
    If (mainmenuopen <> 0) Then
        Return $00
    EndIf
    For local0 = $02 To networkserver\Field14 Step $01
        If (player[local0] <> Null) Then
            If (player[local0]\Field43 <> 0) Then
                udp_writebyte($68)
                udp_writebyte($01)
                udp_writebyte(arg0)
                Select network_byte[arg0]
                    Case $3D
                        multiplayer_writenpcs(local0)
                    Case $32
                        multiplayer_writedoors(local0)
                    Case $42
                        multiplayer_writeitems(local0)
                    Case $53
                        multiplayer_writeevents()
                    Case $54
                        multiplayer_writeroomobjects()
                End Select
                udp_sendmessage(local0)
            EndIf
        EndIf
    Next
    Return $00
End Function
