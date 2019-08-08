//
//  ViewController.swift
//  yaba-ios
//
//  Created by Jeremy Rempel on 7/22/19.
//  Copyright © 2019 Jeremy Rempel. All rights reserved.
//

import UIKit
import lib

class PhotoDetailViewController: UIViewController {
    
    //    var data: Int = 0
    var data: ListPhotoResponseRow?
    
    @IBOutlet weak var photoDetailLabel: UILabel!
    @IBOutlet weak var photoDetailImage: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        //        let greeting = SampleKt.hello()
        //        print("Kotlin Greeting: \"\(greeting)\"")
        print("received data \(String(describing: data?.description()))")
        
        if let thumbUrl = data?.imageUrl, let title = data?.title {
            photoDetailLabel.text = title
            let url = URL(string: thumbUrl)
            photoDetailImage.kf.setImage(with: url)
        }
    }
}
