Function steambrowser_destroy%(arg0.steambrowser)
    freetexture(arg0\Field10)
    freeimage(arg0\Field9)
    bs_isteamhtmlsurface_removebrowser(bs_steamhtmlsurface(), arg0\Field0)
    Delete arg0
    Return $00
End Function
