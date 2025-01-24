Function affectdecaydoor%(arg0.doors)
    Local local0%
    Select arg0\Field10
        Case $00,$06,$01
            local0 = loadtexture_strict("GFX\Map\Textures\Door01_Corrosive.png", $01, $00, $01)
        Case $02
            local0 = loadtexture_strict("GFX\Map\Textures\containment_doors_Corrosive.png", $01, $00, $01)
    End Select
    entitytexture(arg0\Field0, local0, $00, $00)
    If (arg0\Field1 <> $00) Then
        entitytexture(arg0\Field1, local0, $00, $00)
    EndIf
    entitytexture(arg0\Field2, local0, $00, $00)
    deletesingletextureentryfromcache(local0, $00)
    local0 = $00
    arg0\Field27 = $01
    Return $00
End Function
