Function update294%()
    Local local0%
    Local local1.decals
    If (0.0 < camerashaketimer) Then
        camerashaketimer = (camerashaketimer - (fpsfactor / 70.0))
        camerashake = 2.0
    EndIf
    If (0.0 < vomittimer) Then
        debuglog((Str vomittimer))
        vomittimer = (vomittimer - (fpsfactor / 70.0))
        If ((millisecs2() Mod $640) < rand($C8, $190)) Then
            If (0.0 = blurtimer) Then
                blurtimer = (rnd(10.0, 20.0) * 70.0)
            EndIf
            camerashake = rnd(0.0, 2.0)
        EndIf
        If (((rand($32, $01) = $32) And ((millisecs2() Mod $FA0) < $C8)) <> 0) Then
            playsound_strict(coughsfx(rand($00, $02)))
        EndIf
        If (((10.0 > vomittimer) And (2.0 > rnd(0.0, (500.0 * vomittimer)))) <> 0) Then
            If (((channelplaying(vomitchn) = $00) And (regurgitate = $00)) <> 0) Then
                vomitchn = playsound_strict(loadtempsound((("SFX\SCP\294\Retch" + (Str rand($01, $02))) + ".ogg")))
                multiplayer_writetempsound((("SFX\SCP\294\Retch" + (Str rand($01, $02))) + ".ogg"), entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
                regurgitate = (millisecs2() + $32)
            EndIf
        EndIf
        If (((regurgitate > millisecs2()) And (regurgitate <> $00)) <> 0) Then
            mouse_y_speed_1 = (mouse_y_speed_1 + 1.0)
        Else
            regurgitate = $00
        EndIf
    ElseIf (0.0 > vomittimer) Then
        vomittimer = (vomittimer - (fpsfactor / 70.0))
        If (-5.0 < vomittimer) Then
            If ((millisecs2() Mod $190) < $32) Then
                camerashake = 4.0
            EndIf
            mouse_x_speed_1 = 0.0
            playable = $00
        Else
            playable = $01
        EndIf
        If (vomit = $00) Then
            blurtimer = 2800.0
            vomitsfx = loadsound_strict("SFX\SCP\294\Vomit.ogg")
            vomitchn = playsound_strict(vomitsfx)
            multiplayer_writetempsound("SFX\SCP\294\Vomit.ogg", entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), 10.0, 1.0)
            previnjuries = injuries
            prevbloodloss = bloodloss
            injuries = 1.5
            bloodloss = 70.0
            eyeirritation = 630.0
            local0 = createpivot($00)
            positionentity(local0, entityx(camera, $00), (entityy(collider, $00) - 0.05), entityz(camera, $00), $00)
            turnentity(local0, 90.0, 0.0, 0.0, $00)
            entitypick(local0, 0.3)
            local1 = createdecal($05, pickedx(), (pickedy() + 0.005), pickedz(), 90.0, 180.0, 0.0, 1.0, 1.0)
            local1\Field2 = 0.001
            local1\Field1 = 0.001
            local1\Field3 = 0.6
            entityalpha(local1\Field0, 1.0)
            entitycolor(local1\Field0, 0.0, rnd(200.0, 255.0), 0.0)
            scalesprite(local1\Field0, local1\Field2, local1\Field2)
            multiplayer_writedecal(local1, $01, $01)
            freeentity(local0)
            vomit = $01
        EndIf
        updatedecals()
        mouse_y_speed_1 = (max(((vomittimer / 10.0) + 1.0), 0.0) + mouse_y_speed_1)
        If (-15.0 > vomittimer) Then
            freesound_strict(vomitsfx)
            vomittimer = 0.0
            If (0.0 <= killtimer) Then
                playsound_strict(breathsfx($00, $00))
            EndIf
            injuries = previnjuries
            bloodloss = prevbloodloss
            vomit = $00
        EndIf
    EndIf
    Return $00
End Function
