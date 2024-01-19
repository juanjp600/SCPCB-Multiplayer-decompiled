Function updatechat%()
    Local local0%
    Local local1%
    Local local2.chatmessage
    ticks\Field0 = $00
    For local2 = Each chatmessage
        If (local2\Field2 < millisecs()) Then
            Delete local2
        EndIf
    Next
    For local2 = Each chatmessage
        ticks\Field0 = (ticks\Field0 + $01)
        If (ticks\Field0 > $FF) Then
            ticks\Field0 = $00
        EndIf
    Next
    Return $00
End Function
