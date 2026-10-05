Function shoot%(arg0.npcs, arg1#, arg2#, arg3#, arg4#, arg5%, arg6%)
    Local local0.particles
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    local0 = createparticle(arg1, arg2, arg3, $01, rnd(0.08, 0.1), 0.0, $05, 1.0, $01)
    rotatesprite(local0\Field0, (Float rand($168, $01)))
    entityfx(local0\Field0, $09)
    lightvolume = (templightvolume * 1.2)
    If (arg6 <> 0) Then
        If (arg0\Field76 = networkserver\Field20) Then
            If (godmode = $00) Then
                kill("was killed by shoot", $00)
                playsound_strict(bullethitsfx)
                multiplayer_writesound(bullethitsfx, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 5.0, 1.0)
            EndIf
        Else
            givedamage(arg0\Field76, -1.0)
        EndIf
        Return $00
    EndIf
    If (arg5 = $00) Then
        If (arg4 >= rnd(1.0, 0.0)) Then
            If (((arg0\Field76 = networkserver\Field20) And (godmode = $00)) <> 0) Then
                bullethitmessage()
            Else
                givedamage(arg0\Field76, rnd(2.0, 4.0))
            EndIf
        EndIf
    Else
        tformvector(0.0, 0.0, 20.0, arg0\Field0, $00)
        local1 = tformedx()
        local2 = tformedy()
        local3 = tformedz()
        local4 = linepick(arg1, arg2, arg3, local1, local2, local3, 0.0)
        If (local4 <> $00) Then
            If (createbullet($00, 1.5, arg1, arg2, arg3, (entitypitch(arg0\Field0, $00) + (Float rand($FFFFFFF1, $0F))), (entityyaw(arg0\Field0, $00) + (Float rand($FFFFFFF1, $0F))), $00) <> 0) Then
                If (((arg0\Field76 = networkserver\Field20) And (godmode = $00)) <> 0) Then
                    bullethitmessage()
                Else
                    givedamage(arg0\Field76, rnd(2.0, 4.0))
                EndIf
            EndIf
        EndIf
    EndIf
    Return $00
End Function
