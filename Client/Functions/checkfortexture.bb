Function checkfortexture%(arg0%, arg1%)
    Local local0$
    Local local1$
    Local local2%
    local0 = ""
    local1 = texturename(arg0)
    If (filetype(local1) = $01) Then
        local0 = local1
    ElseIf (filetype(("GFX\Map\Textures\" + strippath(local1))) = $01) Then
        local0 = ("GFX\Map\Textures\" + strippath(local1))
    EndIf
    local2 = loadtexturecheckingifincache(local0, arg1, $00)
    If (local2 <> $00) Then
        textureblend(local2, (((((arg1 Shr $01) Mod $02) = $00) Shl $02) + $01))
    EndIf
    Return local2
    Return $00
End Function
