Function menpcseesplayer%(arg0.npcs, arg1%)
    If (notarget <> 0) Then
        Return $00
    EndIf
    If (((playerdetected = $00) Or (arg0\Field5 <> $08)) <> 0) Then
        If (0.0 >= arg0\Field50) Then
            Return $00
        EndIf
        If (((8.0 - player[arg0\Field76]\Field33) + player[arg0\Field76]\Field34) < entitydistance(arg0\Field75, arg0\Field4)) Then
            Return $00
        EndIf
        If (1.0 < player[arg0\Field76]\Field34) Then
            If (((60.0 < (Abs deltayaw(arg0\Field4, arg0\Field75))) And entityvisible(arg0\Field4, arg0\Field75)) <> 0) Then
                Return $01
            ElseIf (entityvisible(arg0\Field4, arg0\Field75) = $00) Then
                If ((arg1 And crouch) <> 0) Then
                    Return $00
                Else
                    Return $02
                EndIf
            EndIf
        ElseIf (60.0 < (Abs deltayaw(arg0\Field4, arg0\Field75))) Then
            Return $00
        EndIf
        Return entityvisible(arg0\Field4, arg0\Field75)
    Else
        If (((8.0 - player[arg0\Field76]\Field33) + player[arg0\Field76]\Field34) < entitydistance(arg0\Field75, arg0\Field4)) Then
            Return $03
        EndIf
        If (entityvisible(arg0\Field4, arg0\Field75) <> 0) Then
            Return $01
        EndIf
        If (1.0 < player[arg0\Field76]\Field34) Then
            Return $02
        EndIf
        Return $03
    EndIf
    Return $00
End Function
