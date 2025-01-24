Function npcseesplayer%(arg0.npcs, arg1#, arg2#, arg3%)
    Local local0#
    Local local1%
    Local local2#
    Local local3%
    If ((i_268\Field2 Lor chs\Field2) <> 0) Then
        arg0\Field11 = 0.0
        Return $00
    EndIf
    local0 = entitydistancesquared(me\Field60, arg0\Field3)
    If (arg0\Field4 <> $15) Then
        If ((((arg1 * arg1) < local0) Lor (0.0 >= arg0\Field51)) <> 0) Then
            Return $00
        Else
            local1 = entityvisible(arg0\Field3, me\Field60)
            local2 = (Abs deltayaw(arg0\Field3, me\Field60))
            If (1.0 < me\Field42) Then
                If (((arg2 < local2) And local1) <> 0) Then
                    Return $01
                ElseIf (local1 = $00) Then
                    If ((arg3 And me\Field39) <> 0) Then
                        Return $00
                    Else
                        Return $02
                    EndIf
                EndIf
            ElseIf (60.0 < local2) Then
                Return $00
            EndIf
            Return local1
        EndIf
    Else
        local3 = ((me\Field57 * $03) + $00)
        If (local0 < ((((Float (playerroom\Field7\Field6 = $47)) * 4.0) + arg1) * (((Float (playerroom\Field7\Field6 = $47)) * 4.0) + arg1))) Then
            If (rnd(1.0, 1.5) < me\Field42) Then
                local3 = $02
            EndIf
            If ((entityvisible(arg0\Field3, me\Field60) And (arg2 > (Abs deltayaw(arg0\Field3, me\Field60)))) <> 0) Then
                local3 = $01
            EndIf
        EndIf
        Return local3
    EndIf
    Return $00
End Function
