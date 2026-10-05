Function reloadholidaysentities%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    If (halloweenindex <> 0) Then
        halloweenscene[$00] = loadanimmesh_strict("GFX\multiplayer\game\models\Pumpkin1.b3d", $00)
        hideentity(halloweenscene[$00])
        halloweenscene[$01] = loadanimmesh_strict("GFX\multiplayer\game\models\Pumpkin2.b3d", $00)
        hideentity(halloweenscene[$01])
        halloweenscene[$02] = loadanimmesh_strict("GFX\multiplayer\game\models\Pumpkin1.b3d", $00)
        hideentity(halloweenscene[$02])
        halloweenscene[$03] = loadanimmesh_strict("GFX\multiplayer\game\models\Pumpkin2.b3d", $00)
        hideentity(halloweenscene[$03])
        local0 = loadtexture_strict("GFX\npcs\173h.pt", $01)
        entitytexture(g_model\Field13, local0, $00, $00)
        freetexture(local0)
        entityparent(g_model\Field43, findchild(g_model\Field4, "Bip01_Head"), $01)
        moveentity(g_model\Field43, 0.0, 69.0, -2.0)
    EndIf
    If (newyearindex <> 0) Then
        local1 = rndseed()
        seedrnd($4D2)
        For local2 = $01 To $03 Step $01
            halloweenscene[(local2 - $01)] = loadmesh_strict((("GFX\multiplayer\game\models\snow" + (Str local2)) + ".b3d"), $00)
            local3 = loadtexture_strict("GFX\multiplayer\game\models\snow.jpg", $01)
            entitytexture(halloweenscene[(local2 - $01)], local3, $00, $00)
            freetexture(local3)
            local4 = copyentity(easter_egg_model, $00)
            scaleentity(local4, 150.0, 150.0, 150.0, $00)
            entityparent(local4, halloweenscene[(local2 - $01)], $01)
            rotateentity(local4, 0.0, -45.0, 0.0, $01)
            hideentity(halloweenscene[(local2 - $01)])
        Next
        seedrnd(local1)
    EndIf
    Return $00
End Function
