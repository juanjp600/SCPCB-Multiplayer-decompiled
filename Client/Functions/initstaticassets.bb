Function initstaticassets%(arg0%)
    Local local0%
    If (arg0 = $01) Then
        Goto l1ll1l1ll1l1
    EndIf
    If (menuwhite <> $00) Then
        freeimage(menuwhite)
    EndIf
    If (menublack <> $00) Then
        freeimage(menublack)
    EndIf
    If (menuback <> $00) Then
        freeimage(menuback)
    EndIf
    If (menutext <> $00) Then
        freeimage(menutext)
    EndIf
    If (menu173 <> $00) Then
        freeimage(menu173)
    EndIf
    If (quickloadicon <> $00) Then
        freeimage(quickloadicon)
    EndIf
    For local0 = $00 To $03 Step $01
        If (arrowimg(local0) <> $00) Then
            freeimage(arrowimg(local0))
        EndIf
    Next
.l1ll1l1ll1l1
    menuwhite = loadimage_strict("GFX\menu\menuwhite.jpg")
    menublack = loadimage_strict("GFX\menu\menublack.jpg")
    maskimage(menublack, $FF, $FF, $00)
    If (arg0 <> 0) Then
        Return $00
    EndIf
    menuback = loadimage_strict("GFX\menu\back.jpg")
    menutext = loadimage_strict("GFX\menu\scptext.jpg")
    menu173 = loadimage_strict("GFX\menu\173back.jpg")
    quickloadicon = loadimage_strict("GFX\menu\QuickLoading.png")
    resizeimage(menuback, ((Float imagewidth(menuback)) * menuscale), ((Float imageheight(menuback)) * menuscale))
    resizeimage(menutext, ((Float imagewidth(menutext)) * menuscale), ((Float imageheight(menutext)) * menuscale))
    resizeimage(menu173, ((Float imagewidth(menu173)) * menuscale), ((Float imageheight(menu173)) * menuscale))
    resizeimage(quickloadicon, ((Float imagewidth(quickloadicon)) * menuscale), ((Float imageheight(quickloadicon)) * menuscale))
    For local0 = $00 To $03 Step $01
        arrowimg(local0) = loadimage_strict("GFX\menu\arrow.png")
        rotateimage(arrowimg(local0), (Float ($5A * local0)))
        handleimage(arrowimg(local0), $00, $00)
    Next
    Return $00
End Function
