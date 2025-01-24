Function update035label%(arg0%)
    Local local0.itemtemplates
    Local local1.items
    Local local2%
    Local local3%
    Local local4$
    Local local5$
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10$
    Local local11%
    local11 = countsurfaces(arg0)
    If (i_035\Field0 <> 0) Then
        local5 = "035_sad"
    Else
        local5 = "035_smile"
    EndIf
    local4 = (("GFX\Map\Textures\label" + local5) + ".png")
    local8 = loadbrush_strict(local4, $01, 1.0, 1.0)
    For local3 = $01 To local11 Step $01
        local6 = getsurface(arg0, local3)
        local7 = getsurfacebrush(local6)
        local9 = getbrushtexture(local7, $00)
        local10 = strippath(texturename(local9))
        If (lower(local10) <> "cable_white.jpg") Then
            paintsurface(local6, local8)
        EndIf
        freebrush(local7)
        local7 = $00
        freetexture(local9)
        local9 = $00
    Next
    freebrush(local8)
    local8 = $00
    For local0 = Each itemtemplates
        If (local0\Field1 = "Document SCP-035") Then
            If (local0\Field11 <> $00) Then
                freeimage(local0\Field11)
                local0\Field11 = $00
            EndIf
            local0\Field10 = (("GFX\Items\HUD Textures\doc_" + local5) + ".png")
            local0\Field11 = scaleimageex(loadimage_strict(local0\Field10), menuscale, menuscale, $01)
            local0\Field13 = (imagewidth(local0\Field11) Sar $01)
            local0\Field14 = (imageheight(local0\Field11) Sar $01)
            local0\Field20 = local0\Field10
            For local1 = Each items
                If (local1\Field4\Field1 = local0\Field1) Then
                    local2 = getrescaledtexture(local0\Field20, $01, $100, $100, $00)
                    entitytexture(local1\Field3, local2, $00, $00)
                    deletesingletextureentryfromcache(local2, $00)
                    local2 = $00
                    Exit
                EndIf
            Next
            Exit
        EndIf
    Next
    freeimage(s2imapget(achievementsimages, "035"))
    s2imapset(achievementsimages, "035", scaleimageex(loadimage_strict((("GFX\Menu\achievements\Achv" + local5) + ".png")), menuscale, menuscale, $01))
    Return $00
End Function
