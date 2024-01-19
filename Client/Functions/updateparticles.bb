Function updateparticles%()
    Local local0.particles
    For local0 = Each particles
        moveentity(local0\Field1, 0.0, 0.0, (local0\Field9 * fpsfactor))
        If (0.0 <> local0\Field11) Then
            local0\Field10 = (local0\Field10 - (local0\Field11 * fpsfactor))
        EndIf
        translateentity(local0\Field1, 0.0, (local0\Field10 * fpsfactor), 0.0, $01)
        positionentity(local0\Field0, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $01)
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
        local0\Field17 = (local0\Field17 - fpsfactor)
        If ((((0.0 >= local0\Field17) Or (0.00001 > local0\Field7)) Or (0.0 >= local0\Field6)) <> 0) Then
            removeparticle(local0)
        Else
            local0\Field18 = (local0\Field18 - $01)
            If (local0\Field18 = $00) Then
                removeparticle(local0)
            EndIf
        EndIf
    Next
    Return $00
End Function
