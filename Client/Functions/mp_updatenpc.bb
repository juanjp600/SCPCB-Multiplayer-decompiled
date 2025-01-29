Function mp_updatenpc%(arg0.npcs)
    Local local0#
    If ((arg0\Field97 And (arg0\Field5 > $00)) <> 0) Then
        mp_npcs[arg0\Field5] = Null
        arg0\Field5 = $00
    EndIf
    If (((arg0\Field97 = $00) And (mp_ishoster() = $00)) <> 0) Then
        local0 = distancesquared(entityx(arg0\Field3, $00), arg0\Field74, entityy(arg0\Field3, $00), arg0\Field75, entityz(arg0\Field3, $00), arg0\Field76)
        If (0.01 <= local0) Then
            If (0.25 <= local0) Then
                positionentity(arg0\Field3, arg0\Field74, arg0\Field75, arg0\Field76, $01)
            Else
                positionentity(arg0\Field3, curvevalue(arg0\Field74, entityx(arg0\Field3, $00), 4.0), arg0\Field75, curvevalue(arg0\Field76, entityz(arg0\Field3, $00), 4.0), $01)
            EndIf
            resetentity(arg0\Field3)
        EndIf
    EndIf
    Return $00
End Function
