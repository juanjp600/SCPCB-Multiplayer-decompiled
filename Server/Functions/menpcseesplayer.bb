Function menpcseesplayer%(arg0.npcs, arg1%)
    Local local0%
    If (notarget <> 0) Then
        Return $00
    EndIf
    If (((local0 = $00) Or (arg0\Field5 <> $08)) <> 0) Then
        If (0.0 >= arg0\Field49) Then
            Return $00
        EndIf
        If (((8.0 - player[arg0\Field74]\Field26) + player[arg0\Field74]\Field27) < entitydistance(arg0\Field73, arg0\Field4)) Then
            Return $00
        EndIf
        If (1.0 < player[arg0\Field74]\Field27) Then
            If (((60.0 < (Abs deltayaw(arg0\Field4, arg0\Field73))) And entityvisible(arg0\Field4, arg0\Field73)) <> 0) Then
                Return $01
            ElseIf (entityvisible(arg0\Field4, arg0\Field73) = $00) Then
                If ((arg1 And crouch) <> 0) Then
                    Return $00
                Else
                    Return $02
                EndIf
            EndIf
        ElseIf (60.0 < (Abs deltayaw(arg0\Field4, arg0\Field73))) Then
            Return $00
        EndIf
        Return entityvisible(arg0\Field4, arg0\Field73)
    Else
        If (((8.0 - player[arg0\Field74]\Field26) + player[arg0\Field74]\Field27) < entitydistance(arg0\Field73, arg0\Field4)) Then
            Return $03
        EndIf
        If (entityvisible(arg0\Field4, arg0\Field73) <> 0) Then
            Return $01
        EndIf
        If (1.0 < player[arg0\Field74]\Field27) Then
            Return $02
        EndIf
        Return $03
    EndIf
    Return $00
End Function
