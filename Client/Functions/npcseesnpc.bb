Function npcseesnpc%(arg0.npcs, arg1.npcs, arg2#)
    Local local0#
    If (arg2 > entitydistancesquared(arg0\Field3, arg1\Field3)) Then
        If (entityvisible(arg0\Field3, arg1\Field3) <> 0) Then
            Return $01
        EndIf
        If (arg0 = n_i\Field2) Then
            local0 = clamp((distance(entityx(n_i\Field2\Field3, $00), n_i\Field2\Field31, entityz(n_i\Field2\Field3, $00), n_i\Field2\Field33, 0.0, 0.0) * 2.5), 0.0, 1.0)
            If (0.0 < local0) Then
                Return $02
            EndIf
        EndIf
    EndIf
    Return $00
    Return $00
End Function
