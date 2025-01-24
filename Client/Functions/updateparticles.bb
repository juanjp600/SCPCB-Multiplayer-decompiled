Function updateparticles%()
    Local local0.particles
    catcherrors("UpdateParticles()")
    For local0 = Each particles
        If ((hidedistance * hidedistance) >= entitydistancesquared(local0\Field0, me\Field60)) Then
            moveentity(local0\Field1, 0.0, 0.0, (local0\Field4 * fps\Field7[$00]))
            If (0.0 <> local0\Field6) Then
                local0\Field5 = (local0\Field5 - (local0\Field6 * fps\Field7[$00]))
            EndIf
            translateentity(local0\Field1, 0.0, (local0\Field5 * fps\Field7[$00]), 0.0, $01)
            positionentity(local0\Field0, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $01)
            If (0.0 <> local0\Field10) Then
                local0\Field2 = clamp(((local0\Field10 * fps\Field7[$00]) + local0\Field2), 0.0, 1.0)
                entityalpha(local0\Field0, local0\Field2)
            EndIf
            If (0.0 <> local0\Field11) Then
                local0\Field3 = ((local0\Field11 * fps\Field7[$00]) + local0\Field3)
                scalesprite(local0\Field0, local0\Field3, local0\Field3)
            EndIf
            local0\Field12 = (local0\Field12 - fps\Field7[$00])
            If ((((0.0 >= local0\Field12) Lor (0.00001 > local0\Field3)) Lor (0.0 >= local0\Field2)) <> 0) Then
                removeparticle(local0)
            EndIf
        Else
            removeparticle(local0)
        EndIf
    Next
    catcherrors("Uncaught: UpdateParticles()")
    Return $00
End Function
