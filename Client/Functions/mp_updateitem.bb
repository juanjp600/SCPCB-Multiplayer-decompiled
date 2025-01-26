Function mp_updateitem%(arg0.items)
    Local local0.mp_player
    If (mp_getsocket() = $00) Then
        Return $00
    EndIf
    arg0\Field29 = $00
    If (arg0\Field15 <> 0) Then
        local0 = ue_players[arg0\Field27]
        If (entityhidden(arg0\Field2) = $00) Then
            hideentity(arg0\Field2)
        EndIf
        If (local0 <> Null) Then
            arg0\Field29 = (local0\Field26 = arg0\Field19)
            If (local0\Field19 <> $00) Then
                positionentity(arg0\Field2, entityx(local0\Field19, $01), entityy(local0\Field19, $01), entityz(local0\Field19, $01), $01)
                resetentity(arg0\Field2)
            Else
                positionentity(arg0\Field2, local0\Field7, ((local0\Field8 + 0.6) + ((Float local0\Field27) * -0.3)), local0\Field9, $01)
                resetentity(arg0\Field2)
            EndIf
        EndIf
        If (arg0\Field30 = $00) Then
            entityfx(arg0\Field3, $10)
            arg0\Field30 = $01
        EndIf
    Else
        If (arg0\Field30 <> 0) Then
            entityfx(arg0\Field3, $00)
            rotateentity(arg0\Field2, 0.0, entityyaw(arg0\Field2, $00), 0.0, $00)
            arg0\Field30 = $00
        EndIf
        If ((((mp_ishoster() = $00) And (0.0 >= arg0\Field31)) And (0.01 <= distancesquared(entityx(arg0\Field2, $01), arg0\Field32, entityy(arg0\Field2, $01), arg0\Field33, entityz(arg0\Field2, $01), arg0\Field34))) <> 0) Then
            positionentity(arg0\Field2, curvevalue(arg0\Field32, entityx(arg0\Field2, $01), 4.0), curvevalue(arg0\Field33, entityy(arg0\Field2, $01), 4.0), curvevalue(arg0\Field34, entityz(arg0\Field2, $01), 4.0), $01)
            resetentity(arg0\Field2)
            arg0\Field5 = 0.0
        EndIf
    EndIf
    arg0\Field31 = (arg0\Field31 - fps\Field7[$00])
    Return $00
End Function
