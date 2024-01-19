Function initplayerobjects%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4.breachtypes
    If (player[arg0]\Field42 = Null) Then
        player[arg0]\Field42 = (New attachs)
    EndIf
    If (player[arg0]\Field42\Field6 = $00) Then
        local0 = loadtexture_strict("GFX\items\Vest.png", $01)
        local2 = loadtexture_strict("GFX\items\mp5sd_main.png", $01)
        If (newyearindex <> 0) Then
            player[arg0]\Field42\Field8 = copyentity(ny_hat, $00)
            scaleentity(player[arg0]\Field42\Field8, 0.026, 0.023, 0.026, $00)
        EndIf
        player[arg0]\Field42\Field6 = copyentity(vest_obj, $00)
        entitytexture(player[arg0]\Field42\Field6, local0, $00, $00)
        scaleentity(player[arg0]\Field42\Field6, 0.022, 0.045, 0.022, $00)
        player[arg0]\Field42\Field4 = copyentity(gasmask_obj, $00)
        scaleentity(player[arg0]\Field42\Field4, 0.02, 0.02, 0.02, $00)
        player[arg0]\Field42\Field5 = copyentity(nvg_obj, $00)
        scaleentity(player[arg0]\Field42\Field5, 0.02, 0.02, 0.02, $00)
        player[arg0]\Field42\Field7[$01] = copyentity(pistol_object, $00)
        player[arg0]\Field42\Field7[$02] = copyentity(p90_object, $00)
        player[arg0]\Field42\Field7[$03] = copyentity(mp5_object, $00)
        player[arg0]\Field42\Field7[$04] = copyentity(rpg_object, $00)
        player[arg0]\Field42\Field7[$05] = copyentity(minigun_object, $00)
        player[arg0]\Field42\Field7[$06] = copyentity(microhid_object, $00)
        player[arg0]\Field42\Field7[$07] = copyentity(deagle_object, $00)
        player[arg0]\Field42\Field7[$08] = copyentity(shotgun_object, $00)
        player[arg0]\Field42\Field7[$0A] = copyentity(m4a4_object, $00)
        player[arg0]\Field42\Field7[$0B] = copyentity(handcuffs_object, $00)
        player[arg0]\Field42\Field7[$0D] = copyentity(grenade_object, $00)
        player[arg0]\Field42\Field7[$0E] = copyentity(grenadeflashbang_object, $00)
        player[arg0]\Field42\Field7[$0F] = copyentity(grenadesmoke_object, $00)
        player[arg0]\Field42\Field7[$0C] = copyentity(knife_object, $00)
        player[arg0]\Field42\Field7[$09] = copyentity(hkg36_object, $00)
        entitytexture(player[arg0]\Field42\Field7[$03], local2, $00, $00)
        scaleentity(player[arg0]\Field42\Field7[$09], 0.027, 0.027, 0.027, $00)
        scaleentity(player[arg0]\Field42\Field7[$02], 0.02, 0.02, 0.02, $00)
        scaleentity(player[arg0]\Field42\Field7[$01], 0.02, 0.02, 0.02, $00)
        scaleentity(player[arg0]\Field42\Field7[$03], 0.015, 0.015, 0.015, $00)
        scaleentity(player[arg0]\Field42\Field7[$04], 0.012, 0.012, 0.012, $00)
        scaleentity(player[arg0]\Field42\Field7[$05], 0.014, 0.014, 0.014, $00)
        scaleentity(player[arg0]\Field42\Field7[$06], 0.015, 0.015, 0.015, $00)
        scaleentity(player[arg0]\Field42\Field7[$07], 0.02, 0.02, 0.02, $00)
        scaleentity(player[arg0]\Field42\Field7[$08], 0.016, 0.016, 0.016, $00)
        scaleentity(player[arg0]\Field42\Field7[$0A], 0.02, 0.02, 0.02, $00)
        scaleentity(player[arg0]\Field42\Field7[$0D], 0.012, 0.012, 0.012, $00)
        scaleentity(player[arg0]\Field42\Field7[$0E], 0.012, 0.012, 0.012, $00)
        scaleentity(player[arg0]\Field42\Field7[$0F], 0.012, 0.012, 0.012, $00)
        scaleentity(player[arg0]\Field42\Field7[$0C], 0.012, 0.012, 0.012, $00)
        scaleentity(player[arg0]\Field42\Field7[$0B], 0.012, 0.012, 0.012, $00)
        For local3 = $01 To $0F Step $01
            hideentity(player[arg0]\Field42\Field7[local3])
        Next
        If (player[arg0]\Field42\Field8 <> $00) Then
            local4 = getbreachtype(player[arg0]\Field51)
            If ((((0.15 = local4\Field10) And (0.52 = local4\Field11)) And (0.15 = local4\Field12)) <> 0) Then
                If (findchild(player[arg0]\Field42\Field8, "Bone.003") <> $00) Then
                    moveentity(findchild(player[arg0]\Field42\Field8, "Bone.003"), -0.3, 0.0, 0.0)
                    player[arg0]\Field42\Field9[$00] = rd_addentity(findchild(player[arg0]\Field42\Field8, "Bone.004"), findchild(player[arg0]\Field42\Field8, "Bone.003"))
                    player[arg0]\Field42\Field9[$01] = rd_addentity(findchild(player[arg0]\Field42\Field8, "Bone.003"), findchild(player[arg0]\Field42\Field8, "Bone.003"))
                    entityparent(player[arg0]\Field42\Field8, getplayerhead(arg0), $01)
                    positionentity(player[arg0]\Field42\Field8, (entityx(getplayerhead(arg0), $00) - 2.15), entityy(getplayerhead(arg0), $00), (entityz(getplayerhead(arg0), $00) + 0.2), $00)
                    rotateentity(player[arg0]\Field42\Field8, entitypitch(player[arg0]\Field42\Field8, $01), (entityyaw(player[arg0]\Field42\Field8, $01) + 90.0), entityroll(player[arg0]\Field42\Field8, $01), $01)
                Else
                    freeentity(player[arg0]\Field42\Field8)
                    player[arg0]\Field42\Field8 = $00
                EndIf
            Else
                freeentity(player[arg0]\Field42\Field8)
                player[arg0]\Field42\Field8 = $00
            EndIf
        EndIf
        If (player[arg0]\Field42\Field8 <> $00) Then
            hideentity(player[arg0]\Field42\Field8)
        EndIf
        hideentity(player[arg0]\Field42\Field4)
        hideentity(player[arg0]\Field42\Field5)
        hideentity(player[arg0]\Field42\Field6)
        freetexture(local0)
        freetexture(local2)
    EndIf
    Return $00
End Function
