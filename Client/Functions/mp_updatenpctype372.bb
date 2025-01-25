Function mp_updatenpctype372%(arg0.npcs)
    Local local0#
    Local local1#
    Local local2%
    If (playerinreachableroom($01, $00) = $00) Then
        Return $00
    EndIf
    If (1.0 = arg0\Field26) Then
        If (entityhidden(arg0\Field0) = $00) Then
            hideentity(arg0\Field0)
        EndIf
        If (((rand($32, $01) = $01) And ((-5.0 > me\Field10) And (-15.0 < me\Field10))) <> 0) Then
            local0 = (entityyaw(me\Field60, $00) + rnd(-90.0, 90.0))
            local1 = rnd(1.5, 2.0)
            positionentity(arg0\Field3, (entityx(me\Field60, $00) + (sin(local0) * local1)), (entityy(me\Field60, $00) + 0.2), (entityz(me\Field60, $00) + (cos(local0) * local1)), $00)
            arg0\Field26 = 0.0
            arg0\Field10 = rnd(20.0, 60.0)
            If (rand($12C, $01) = $01) Then
                playsoundex(snd_i\Field27[rand($00, $05)], camera, arg0\Field3, 8.0, rnd(0.0, 0.2), $00, $00)
            EndIf
        EndIf
    EndIf
    If (0.0 = arg0\Field26) Then
        If (entityhidden(arg0\Field0) <> 0) Then
            showentity(arg0\Field0)
        EndIf
        positionentity(arg0\Field0, (entityx(arg0\Field3, $00) + rnd(-0.005, 0.005)), ((entityy(arg0\Field3, $00) + 0.3) + (sin(((Float millisec) / 2.0)) * 0.1)), (entityz(arg0\Field3, $00) + rnd(-0.005, 0.005)), $00)
        rotateentity(arg0\Field0, 0.0, entityyaw(arg0\Field3, $00), (((Float millisec) / 5.0) Mod 360.0), $00)
        animatenpc(arg0, 1.0, 300.0, rnd(0.8, 2.5), $01)
        If ((entityinview(arg0\Field0, camera) And ((-16.0 > me\Field10) Lor (-6.0 < me\Field10))) <> 0) Then
            giveachievement("372", $01)
            If (rand($1E, $01) = $01) Then
                If (entityvisible(camera, arg0\Field0) <> 0) Then
                    If (channelplaying(arg0\Field18) = $00) Then
                        arg0\Field18 = playsoundex(snd_i\Field27[rand($00, $05)], camera, arg0\Field0, 8.0, 0.3, $00, $00)
                    EndIf
                EndIf
            EndIf
            local2 = createpivot($00)
            positionentity(local2, entityx(me\Field60, $00), entityy(me\Field60, $00), entityz(me\Field60, $00), $00)
            pointentity(local2, arg0\Field3, 0.0)
            local0 = wrapangle((entityyaw(me\Field60, $00) - entityyaw(local2, $00)), 360.0)
            If (180.0 > local0) Then
                rotateentity(arg0\Field3, 0.0, (entityyaw(me\Field60, $00) - 80.0), 0.0, $00)
            Else
                rotateentity(arg0\Field3, 0.0, (entityyaw(me\Field60, $00) + 80.0), 0.0, $00)
            EndIf
            freeentity(local2)
            local2 = $00
            moveentity(arg0\Field3, 0.0, 0.0, (fps\Field7[$00] * 0.03))
        EndIf
        arg0\Field10 = (arg0\Field10 - (fps\Field7[$00] * 0.8))
        If (0.0 >= arg0\Field10) Then
            arg0\Field26 = 1.0
            positionentity(arg0\Field3, 0.0, -500.0, 0.0, $00)
        EndIf
    EndIf
    arg0\Field7 = 0.0
    resetentity(arg0\Field3)
    Return $00
End Function
