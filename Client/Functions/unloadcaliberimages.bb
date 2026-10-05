Function unloadcaliberimages%()
    If (calibers <> $00) Then
        ;bbFieldPtrAdd at _funloadcaliberimages:31, probably for an object of unknowable type
        freeimage(eax_0008)
        ;bbFieldPtrAdd at _funloadcaliberimages:45, probably for an object of unknowable type
        freeimage(eax_000E)
        ;bbFieldPtrAdd at _funloadcaliberimages:59, probably for an object of unknowable type
        freeimage(eax_0014)
        ;bbFieldPtrAdd at _funloadcaliberimages:73, probably for an object of unknowable type
        freeimage(eax_001A)
        ;bbFieldPtrAdd at _funloadcaliberimages:87, probably for an object of unknowable type
        freeimage(eax_0020)
        ;bbFieldPtrAdd at _funloadcaliberimages:101, probably for an object of unknowable type
        freeimage(eax_0026)
        ;bbFieldPtrAdd at _funloadcaliberimages:115, probably for an object of unknowable type
        freeimage(eax_002C)
        ;bbFieldPtrAdd at _funloadcaliberimages:129, probably for an object of unknowable type
        freeimage(eax_0032)
        Delete calibers
        calibers = $00
    EndIf
    Return $00
End Function
