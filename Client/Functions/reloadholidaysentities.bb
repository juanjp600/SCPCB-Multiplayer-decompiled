Function reloadholidaysentities%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    If (halloweenindex <> 0) Then
        freeentity(grenade_object)
        grenade_object = loadmesh_strict("GFX\items\grenadeworldmodelHw.b3d", $00)
        halloweenscene[$00] = loadanimmesh_strict("GFX\multiplayer\game\models\Pumpkin1.b3d", $00)
        hideentity(halloweenscene[$00])
        halloweenscene[$01] = loadanimmesh_strict("GFX\multiplayer\game\models\Pumpkin2.b3d", $00)
        hideentity(halloweenscene[$01])
        halloweenscene[$02] = loadanimmesh_strict("GFX\multiplayer\game\models\Pumpkin1.b3d", $00)
        hideentity(halloweenscene[$02])
        halloweenscene[$03] = loadanimmesh_strict("GFX\multiplayer\game\models\Pumpkin2.b3d", $00)
        hideentity(halloweenscene[$03])
        local0 = loadtexture_strict("GFX\npcs\173h.pt", $01)
        entitytexture(object_173, local0, $00, $00)
        freetexture(local0)
        entityparent(local1, findchild(classdobj, "Bip01_Head"), $01)
        moveentity(local1, 0.0, 69.0, -2.0)
    EndIf
    If (newyearindex <> 0) Then
        local2 = rndseed()
        seedrnd($4D2)
        For local3 = $01 To $03 Step $01
            halloweenscene[(local3 - $01)] = loadmesh_strict((("GFX\multiplayer\game\models\snow" + (Str local3)) + ".b3d"), $00)
            local4 = loadtexture_strict("GFX\multiplayer\game\models\snow.jpg", $01)
            entitytexture(halloweenscene[(local3 - $01)], local4, $00, $00)
            freetexture(local4)
            local5 = copyentity(easter_egg_model, $00)
            scaleentity(local5, 150.0, 150.0, 150.0, $00)
            entityparent(local5, halloweenscene[(local3 - $01)], $01)
            rotateentity(local5, 0.0, -45.0, 0.0, $01)
            hideentity(halloweenscene[(local3 - $01)])
        Next
        seedrnd(local2)
    EndIf
    Return $00
End Function
