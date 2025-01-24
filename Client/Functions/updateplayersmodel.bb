Function updateplayersmodel%()
    Local local0.mp_player
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    For local0 = Each mp_player
        initializeplayermodel(local0)
        If (local0\Field35\Field0 <> $00) Then
            If (entityhidden(local0\Field35\Field0) = $00) Then
                hideentity(local0\Field35\Field0)
            EndIf
            If ((hidedistance * hidedistance) > entitydistancesquared(local0\Field35\Field0, me\Field60)) Then
                If ((entityhidden(local0\Field35\Field0) And (local0\Field30 = $00)) <> 0) Then
                    showentity(local0\Field35\Field0)
                EndIf
                If (((animseq(local0\Field35\Field0) <> local0\Field14) And (0.0 <> local0\Field35\Field1\Field23[local0\Field14])) <> 0) Then
                    animate(local0\Field35\Field0, $01, local0\Field35\Field1\Field23[local0\Field14], local0\Field14, 10.0)
                    local0\Field27 = ((local0\Field14 >= $04) And (local0\Field14 <= $05))
                    positionentity(local0\Field19, 0.0, (((Float local0\Field27) * -0.3) + 0.6), 0.0, $00)
                EndIf
                If (local0\Field35\Field2 <> $00) Then
                    local1 = clamp((((Float local0\Field35\Field1\Field4) / (Float local0\Field35\Field1\Field5)) * local0\Field12), (Float (- local0\Field35\Field1\Field5)), (Float local0\Field35\Field1\Field5))
                    local2 = local0\Field13
                    If (local0\Field35\Field1\Field6 > $00) Then
                        If (((isequal(0.0, angledist(local0\Field35\Field7, local2), (Float local0\Field35\Field1\Field6)) = $00) Or (0.001 < local0\Field23)) <> 0) Then
                            local0\Field35\Field6 = local2
                        EndIf
                        local0\Field35\Field7 = curveangle(local0\Field35\Field6, local0\Field35\Field7, 7.0)
                        local3 = angledist(local0\Field35\Field7, local2)
                        If (local3 <= (Float (- local0\Field35\Field1\Field6))) Then
                            local2 = wrapangle((local0\Field35\Field7 + (Float local0\Field35\Field1\Field6)), 360.0)
                        ElseIf (local3 >= (Float local0\Field35\Field1\Field6)) Then
                            local2 = wrapangle((local0\Field35\Field7 - (Float local0\Field35\Field1\Field6)), 360.0)
                        EndIf
                    Else
                        local0\Field35\Field7 = local0\Field13
                    EndIf
                    rotateentity(local0\Field35\Field0, 0.0, (local0\Field35\Field7 - local0\Field35\Field1\Field8), 0.0, $01)
                    local4 = 0.0
                    If (local0\Field31 > $00) Then
                        local4 = (((Float (local0\Field31 = $02)) * 30.0) + -15.0)
                    EndIf
                    local0\Field35\Field15 = curvevalue(local4, local0\Field35\Field15, 6.0)
                    If (local0\Field35\Field1\Field7 <> 0) Then
                        rotateentity(local0\Field35\Field2, local1, local2, (local0\Field35\Field9 + local0\Field35\Field15), $01)
                    Else
                        rotateentity(local0\Field35\Field2, local1, local2, (entityroll(local0\Field35\Field2, $01) + local0\Field35\Field15), $01)
                    EndIf
                Else
                    rotateentity(local0\Field35\Field0, 0.0, (local0\Field35\Field7 - local0\Field35\Field1\Field8), 0.0, $01)
                    local0\Field35\Field7 = local0\Field13
                EndIf
                If (local0\Field35\Field3 <> $00) Then
                    If (local0\Field35\Field1\Field7 <> 0) Then
                        rotateentity(local0\Field35\Field3, local0\Field12, local0\Field13, local0\Field35\Field8, $01)
                    Else
                        rotateentity(local0\Field35\Field3, local0\Field12, local0\Field13, entityroll(local0\Field35\Field3, $01), $01)
                    EndIf
                EndIf
                updateplayermodelsounds(local0)
                updateplayermodelselecteditem(local0)
            EndIf
        EndIf
        updateplayerattaches(local0)
    Next
    Return $00
End Function
