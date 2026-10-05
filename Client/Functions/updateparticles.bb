Function updateparticles%()
    Local local0.particles
    For local0 = Each particles
        moveentity(local0\Field1, 0.0, 0.0, (local0\Field6 * fpsfactor))
        If (0.0 <> local0\Field8) Then
            local0\Field7 = (local0\Field7 - (local0\Field8 * fpsfactor))
        EndIf
        moveentity(local0\Field1, 0.0, (local0\Field7 * fpsfactor), 0.0)
        positionentity(local0\Field0, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $01)
        If (0.0 <> local0\Field12) Then
            local0\Field3 = min(max((local0\Field3 + (local0\Field12 * fpsfactor)), 0.0), 1.0)
            entityalpha(local0\Field0, local0\Field3)
        EndIf
        If (0.0 <> local0\Field13) Then
            local0\Field4 = (local0\Field4 + (local0\Field13 * fpsfactor))
            scalesprite(local0\Field0, local0\Field4, local0\Field4)
            If (0.0 <> local0\Field5) Then
                If (local0\Field4 >= local0\Field5) Then
                    local0\Field13 = 0.0
                EndIf
            EndIf
        EndIf
        local0\Field14 = (local0\Field14 - fpsfactor)
        If ((((0.0 >= local0\Field14) Or (0.00001 > local0\Field4)) Or (0.0 >= local0\Field3)) <> 0) Then
            removeparticle(local0)
        Else
            local0\Field15 = (local0\Field15 - $01)
            If (local0\Field15 = $00) Then
                removeparticle(local0)
            EndIf
        EndIf
    Next
    Return $00
End Function
