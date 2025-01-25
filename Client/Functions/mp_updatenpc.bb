Function mp_updatenpc%(arg0.npcs)
    Local local0#
    If ((arg0\Field95 And (arg0\Field5 > $00)) <> 0) Then
        mp_npcs[arg0\Field5] = Null
        arg0\Field5 = $00
    EndIf
    If (((arg0\Field95 = $00) And (mp_ishoster() = $00)) <> 0) Then
        local0 = distancesquared(entityx(arg0\Field3, $00), arg0\Field72, entityy(arg0\Field3, $00), arg0\Field73, entityz(arg0\Field3, $00), arg0\Field74)
        If (0.01 <= local0) Then
            If (0.25 <= local0) Then
                positionentity(arg0\Field3, arg0\Field72, arg0\Field73, arg0\Field74, $01)
            Else
                positionentity(arg0\Field3, curvevalue(arg0\Field72, entityx(arg0\Field3, $00), 4.0), arg0\Field73, curvevalue(arg0\Field74, entityz(arg0\Field3, $00), 4.0), $01)
            EndIf
            resetentity(arg0\Field3)
        EndIf
    EndIf
    Return $00
End Function
