Function usehandcuffs%()
    Local local0.players
    Local local1%
    Local local2.items
    entitypick(camera, 1.0)
    For local0 = Each players
        If (((((local0\Field13 = pickedentity()) Or (local0\Field12 = pickedentity())) Or (local0\Field19 = pickedentity())) And (local0\Field33 = $00)) <> 0) Then
            If (((multiplayer_isafriend(myplayer\Field51, local0\Field51) = $00) Or local0\Field83) <> 0) Then
                For local1 = $00 To $09 Step $01
                    If (inventory(local1) <> Null) Then
                        If (inventory(local1)\Field3\Field2 = "handcuffs") Then
                            If (networkserver\Field18 = $00) Then
                                udp_bytestreamwritechar($79)
                                udp_bytestreamwritechar(local0\Field0)
                                udp_setmicrobyte($79)
                            Else
                                udp_writebyte($79)
                                udp_writebyte($01)
                                udp_sendmessage(local0\Field0)
                                For local2 = Each items
                                    If (local2\Field22 = local0\Field0) Then
                                        playerdropitem(local2)
                                    EndIf
                                Next
                            EndIf
                            Return $01
                        EndIf
                    EndIf
                Next
            EndIf
            Exit
        EndIf
    Next
    Return $00
    Return $00
End Function
