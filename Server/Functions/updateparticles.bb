Function updateparticles%()
    Local local0.particles
    For local0 = Each particles
        If (0.0 <> local0\Field15) Then
            local0\Field6 = min(max((local0\Field6 + (local0\Field15 * fpsfactor)), 0.0), 1.0)
            entityalpha(local0\Field0, local0\Field6)
        EndIf
        If (0.0 <> local0\Field16) Then
            local0\Field7 = (local0\Field7 + (local0\Field16 * fpsfactor))
            scalesprite(local0\Field0, local0\Field7, local0\Field7)
            If (0.0 <> local0\Field8) Then
                If (local0\Field7 >= local0\Field8) Then
                    local0\Field16 = 0.0
                EndIf
            EndIf
        EndIf
        local0\Field18 = (local0\Field18 - fpsfactor)
        If ((((0.0 >= local0\Field18) Or (0.00001 > local0\Field7)) Or (0.0 >= local0\Field6)) <> 0) Then
            removeparticle(local0)
        EndIf
    Next
    Return $00
End Function
