package com.example;

import java.util.ArrayList;

/**
 * Created by Paul Aranas on 6/4/2016.
 */
public class OregonGardenLibrary {

    private ArrayList<GardenData> gardenInfo;
    private String[] gardenTitlesArray = new String[23];
    private String[] gardenPhotosArray = new String[23];
    private String[] gardenThumbnailsArray = new String[23];
    private String[] gardenCreatorsArray = new String[23];
    private String[] gardenTextBodiesArray = new String[23];

    //Todo: Add Garden Data
    public OregonGardenLibrary() {
        //garden titles
        gardenTitlesArray[0] = "Amazing Water Garden";
        gardenTitlesArray[1] = "Axis Fountain";
        gardenTitlesArray[2] = "Axis Garden";
        gardenTitlesArray[3] = "Ball Horticulture Trial Garden";
        gardenTitlesArray[4] = "Bosque";
        gardenTitlesArray[5] = "Children's Garden";
        gardenTitlesArray[6] = "Conifer Garden";
        gardenTitlesArray[7] = "Home Demonstration Garden";
        gardenTitlesArray[8] = "Honor Garden";
        gardenTitlesArray[9] = "Lewis and Clark Garden ";
        gardenTitlesArray[10] = "Medicinal Garden";
        gardenTitlesArray[11] = "Northwest Garden";
        gardenTitlesArray[12] = "Oak Grove";
        gardenTitlesArray[13] = "Pet Friendly Garden";
        gardenTitlesArray[14] = "Proven Winners Trial Garden";
        gardenTitlesArray[15] = "Rediscovery Forest";
        gardenTitlesArray[16] = "Rose Garden";
        gardenTitlesArray[17] = "Rose Petal Fountain";
        gardenTitlesArray[18] = "Sensory Garden";
        gardenTitlesArray[19] = "Silverton Market Garden";
        gardenTitlesArray[20] = "Train Garden";
        gardenTitlesArray[21] = "Tropical House";
        gardenTitlesArray[22] = "Wetlands";


        //garden photos
        gardenThumbnailsArray[0] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/amazing_water_garden.jpg";
        gardenThumbnailsArray[1] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/axis_fountain.jpg";
        gardenThumbnailsArray[2] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/axis_garden.jpg";
        gardenThumbnailsArray[3] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/ball-garden.jpg";
        gardenThumbnailsArray[4] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/bosque.jpg";
        gardenThumbnailsArray[5] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/children-garden.jpg";
        gardenThumbnailsArray[6] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/conifer-garden.jpg";
        gardenThumbnailsArray[7] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/home_demo_garden.jpg";
        gardenThumbnailsArray[8] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/honor_garden.jpg";
        gardenThumbnailsArray[9] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/lewis_clark_garden.jpg";
        gardenThumbnailsArray[10] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/medicinal_garden.jpg";
        gardenThumbnailsArray[11] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/northwest_garden.jpg";
        gardenThumbnailsArray[12] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/oak_grove.jpg";
        gardenThumbnailsArray[13] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/pet_friendly.jpg";
        gardenThumbnailsArray[14] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/proven_winners.jpg";
        gardenThumbnailsArray[15] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/rediscovery_forest.jpg";
        gardenThumbnailsArray[16] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/rose_garden.jpg";
        gardenThumbnailsArray[17] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/rose_petal_fountain.jpg";
        gardenThumbnailsArray[18] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/sensory_garden.jpg";
        gardenThumbnailsArray[19] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/silverton_market_garden.jpg";
        gardenThumbnailsArray[20] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/train_garden.jpg";
        gardenThumbnailsArray[21] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/tropical_house.jpg";
        gardenThumbnailsArray[22] = "https://storage.googleapis.com/capstoneproject_images/thumbnails/wetlands.jpg";



        gardenPhotosArray[0] = "https://storage.googleapis.com/capstoneproject_images/amazing_water_garden.jpg";
        gardenPhotosArray[1] = "https://storage.googleapis.com/capstoneproject_images/axis_fountain.jpg";
        gardenPhotosArray[2] = "https://storage.googleapis.com/capstoneproject_images/axis_garden.jpg";
        gardenPhotosArray[3] = "https://storage.googleapis.com/capstoneproject_images/ball_horticulture.jpg";
        gardenPhotosArray[4] = "https://storage.googleapis.com/capstoneproject_images/bosque.jpg";
        gardenPhotosArray[5] = "https://storage.googleapis.com/capstoneproject_images/childrens_garden.jpg";
        gardenPhotosArray[6] = "https://storage.googleapis.com/capstoneproject_images/conifer_garden.jpg";
        gardenPhotosArray[7] = "https://storage.googleapis.com/capstoneproject_images/home_demo_garden.jpg";
        gardenPhotosArray[8] = "https://storage.googleapis.com/capstoneproject_images/honor_garden.jpg";
        gardenPhotosArray[9] = "https://storage.googleapis.com/capstoneproject_images/lewis_clark.jpg";
        gardenPhotosArray[10] = "https://storage.googleapis.com/capstoneproject_images/medicinal_garden.jpg";
        gardenPhotosArray[11] = "https://storage.googleapis.com/capstoneproject_images/northwest_garden.jpg";
        gardenPhotosArray[12] = "https://storage.googleapis.com/capstoneproject_images/oak_grove.jpg";
        gardenPhotosArray[13] = "https://storage.googleapis.com/capstoneproject_images/pet_friendly_garden.jpg";
        gardenPhotosArray[14] = "https://storage.googleapis.com/capstoneproject_images/proven_winners_garden.jpg";
        gardenPhotosArray[15] = "https://storage.googleapis.com/capstoneproject_images/rediscovery_forest.jpg";
        gardenPhotosArray[16] = "https://storage.googleapis.com/capstoneproject_images/rose_garden.jpg";
        gardenPhotosArray[17] = "https://storage.googleapis.com/capstoneproject_images/rose_petal.jpg";
        gardenPhotosArray[18] = "https://storage.googleapis.com/capstoneproject_images/sensory_garden.jpg";
        gardenPhotosArray[19] = "https://storage.googleapis.com/capstoneproject_images/silverton_market_garden.jpg";
        gardenPhotosArray[20] = "https://storage.googleapis.com/capstoneproject_images/train_garden.jpg";
        gardenPhotosArray[21] = "https://storage.googleapis.com/capstoneproject_images/tropical_house.jpg";
        gardenPhotosArray[22] = "https://storage.googleapis.com/capstoneproject_images/wetlands.jpg";


        //garden creators
        gardenCreatorsArray[0] = "Designer: Carol Mayer-Reed";
        gardenCreatorsArray[1] = "Designer: Cascade Landscape";
        gardenCreatorsArray[2] = "Fountain Architect: Gil Williams";
        gardenCreatorsArray[3] = "";
        gardenCreatorsArray[4] = "";
        gardenCreatorsArray[5] = "";
        gardenCreatorsArray[6] = "Designers: Brian Bainnson, Quatrefoil Inc, Conifer Garden Committee, Western Region of the American Conifer Society";
        gardenCreatorsArray[7] = "";
        gardenCreatorsArray[8] = "Designer: Julia Lundy";
        gardenCreatorsArray[9] = "Designers: Amy Whitworth, Kathryn Leech and Mike Faha";
        gardenCreatorsArray[10] = "";
        gardenCreatorsArray[11] = "Designers: Mert Hauck and Andy Rice";
        gardenCreatorsArray[12] = "";
        gardenCreatorsArray[13] = "Designer: Al Shay";
        gardenCreatorsArray[14] = "";
        gardenCreatorsArray[15] = "";
        gardenCreatorsArray[16] = "";
        gardenCreatorsArray[17] = "Fountain Designer: Perron Collaborative";
        gardenCreatorsArray[18] = "Designers: Mark Epstein, Brian Bainnson, and Maurice Horn";
        gardenCreatorsArray[19] = "Designers: Ron Thompson, Mike Wellman, and The Silverton Market Garden Committee";
        gardenCreatorsArray[20] = "Designer: Mike Cady";
        gardenCreatorsArray[21] = "";
        gardenCreatorsArray[22] = "";


        //garden text bodies
        gardenTextBodiesArray[0] = "The award-winning Amazing Water Garden beautifully incorporates a circular water garden with an ornate bridge, criss-crossing paths and a cascading waterfall.\n" +
                "\n" +
                "This area combines wildlife habitat and treated wastewater recycling with the creation of a botanical haven, functions that typically are kept separate. It is a shining example of how public gardens can serve multiple purposes. In 2002, the Amazing Water Garden received an Honor Award in the area of Environmental/ Sustainable Design from the Oregon Chapter of the American Society of Landscape Architects.\n" +
                "\n" +
                "Plants of Interest: Some of the primary plants growing under water in the Amazing Water Garden are Elodea canadensis (native to North America), commonly known as American Pondweed, and Potamogeton crispus (native to Europe and Asia), commonly known as Curly Leaf Pondweed. Additional plants in this garden include Candelabra, Hibiscus, and Wild Lilies.\n" +
                "\n" +
                "Art in the Garden: Heron by Tom Hardy, 1970. Donated by Margueritte Drake.\n" +
                "\n";


        gardenTextBodiesArray[1] = "\n" +
                "This garden is nestled next to the Conifer Garden and above the Bosque. The Axis Garden is designed to be a pattern of turf and ornamental plantings that features seasonal color displays. The Axis Garden is the spine of the Garden, leading up to the Oregon Garden Resort. Standing at the Axis Fountain, raised above the Axis Garden, gives you a wonderful view of this design feature. This garden is a great place to view the many different varieties of conifers that line the outside of the Conifer Garden.\n" +
                "\n" +
                "Plants of Interest: Plants in the Axis Garden include Cotoneaster, Bluebeards, and Full Moon Maples. A beautiful display of what lightning can do to a tree is best viewed from this garden. Our Sequoiadendron giganteum was struck on September 5, 2013. It’s been left in this condition in the Garden for educational purposes.";
        gardenTextBodiesArray[2] = "The Axis Fountain is located at the top of the Axis Garden and features a beautiful fountain of Montana stone and a cascading wall of water. Upper and lower level seating offers breathtaking vistas of the Garden and the Willamette Valley beyond. The Tokarski Family of Salem provided generous financial support for the Axis Fountain.";
        gardenTextBodiesArray[3] = "Ball Horticulture is a world leader in plant development and distribution. Working with The Oregon Garden, they are collecting data from this trial garden that will help them produce plants that will ultimately find their way into your gardens. This garden contains plants that have recently been released to the market, as well as plants that are being evaluated for performance to determine if they provide improvements to current availability.\n" +
                "\n" +
                "Ball is on a continuous, many-faceted journey to find the healthiest, most sustainable solutions in horticulture. Starting with innovative plants, ending with consumer satisfaction and including every step in between, Ball’s goal in everything they do is to make tomorrow better than today. Innovative breeding – dedicated to bringing better plants to market that need less water and energy to flourish; responsible growing practices – give growers options for adopting compostable and biodegradable containers, organically based fertilizers, organic seed and environmentally sound growing methods; community commitments – educational, financial, medical, beautification and workplace-safety programs are in place in Ball’s locations around the world. You can help us and Ball Horticulture by completing our guest survey about the Ball Horticulture Display and Test Garden. The information you provide will help Ball create the best possible product. Guest surveys can be obtained from the Visitor Center as you enter the Garden.\n" +
                "\n" +
                "Plants of Interest: The types of plants in this garden are ever-changing and always include new and exciting varieties.\n" +
                "Location: The Ball Horticulture Display and Trial Garden is located between the Axis Fountain and the Silverton Market Garden.\n" +
                " ";
        gardenTextBodiesArray[4] = "\n" +
                "Bosque (bohs-kay’) – Bosque is a Spanish word meaning grove. The Bosque is a large central plaza featuring four brick reflecting ponds and 40 planter boxes, each planted with a single Pacific Sunset Maple. The colorful foliage of the maple trees reflect in the dark surface of the ponds. In the fall, these trees leaves’ change to the most striking shades of yellow, orange, and red. A stunning sight not to be missed. \n" +
                "\n" +
                "This is a spectacular garden to host any special occasion such as your wedding ceremony and reception.";
        gardenTextBodiesArray[5] = "Let your imagination run wild – as well as the kids – in the Children’s Garden!\n" +
                "\n" +
                "Discover dinosaur bones in our ‘Dinosaur Dig’.\n" +
                "Pretend you are living in the jungle at the top of the trees in our tree house.\n" +
                "Make believe you’ve been magically transported to the land of the Hobbits, and climb in and over a real Hobbit House.\n" +
                "Of course this is still a garden, so wonder at the animal-shaped topiary, watch the furniture garden grow, and figure out why the 'weird plants' look like they do.\n" +
                "\n" +
                "The Children’s Garden at The Oregon Garden is the perfect place to make family memories outdoors, surrounded by nature. During a day of play, bring a picnic or pick up lunch from the Garden Cafe to enjoy. Along with fun activities in the Children’s Garden, kids will also enjoy participating in Junior Gardener’s Club educational activities and other fun Oregon Garden events throughout the year, such as Fireworks on July 3rd, Movies in the Garden and Christmas in the Garden. The Children’s Garden features a covered, open-air pavilion set with tables and chairs, making it the perfect birthday party destination any time of year.\n" +
                "\n" +
                "Plants of Interest: In the Weird Plants Garden located inside the Children’s Garden you will find many fun and interesting plants. A Toad Lily, Lamb’s Ears, and a Mouse Tail Plant all live here. Art in the Garden: Right outside of the Children’s Garden you can find Slugfest- a fun drinking fountain by artist Ellen Tykeson and donated by the Oregon Lottery.";
        gardenTextBodiesArray[6] = "The Conifer Garden, a great example of year-round interest, boasts one of the largest collections of dwarf and miniature conifers in the United States. Some are one-of-a-kinds and have been collected from around the world. The garden also includes a variety of companion plants such as Japanese maples, Daphnes, heathers and heaths. This unique, specialty garden was built in partnership with the Western Region of the American Conifer Society (ACS). The Western Region provides on-going expertise to assure the Garden remains one of the finest showcases for conifers in the country.\n" +
                "\n" +
                "Conifer Garden Expansion: The ACS Western Region is now assisting to almost double the size of the Garden to also display conifers in landscaped settings. An additional goal is to accurately and completely label each conifer creating a living reference garden. All Conifer of the Year selections, both past and future, will also be proudly displayed. The ACS Western Region and The Oregon Garden Foundation need your help to make this dream a reality. Click here to view & print the Conifer Garden Expansion Brochure and donation form. Gifts may also be submitted online through Network for Good, just include Conifer Garden Expansion as your designation. All one-time or pledged gifts over $1,000 will be permanently recognized.";
        gardenTextBodiesArray[7] = "\n" +
                "The Home Demonstration Garden is a series of small gardens that are designed to inspire gardeners with ideas they can take home. Each garden is sponsored, designed and maintained by a different nursery or landscape firm, and each demonstrates a different element of garden design, such as the use of annual color, creating a garden room or building a water garden. They are designed on a scale more suited to the home garden.\n" +
                "\n" +
                "Nurseries and organizations currently involved in this program are:\n" +
                "\n" +
                "Al’s Garden Centers are family owned and operated and are located in Woodburn, Sherwood, and Gresham. They have been helping their neighbors turn their house into a home since 1948. This home demonstration garden showcases annual color.\n" +
                "\n" +
                "Garland Nursery is proudly family-owned and operated for over 70 years, basing their business upon honesty, integrity, open communication, superior products that anticipate and exceed the needs of the marketplace, and specialize in service to people. The Garland Nursery home demonstration garden uses limited space to create an intimate garden setting.\n" +
                "\n" +
                "One Green World – This home demonstration garden is an edible landscape, showcasing dwarf varieties of fruiting trees and shrubs for the home landscape. One Green World offers unique Fruits and Ornamentals from around the world\n" +
                "\n" +
                "Marion County Home Composting Demonstration Center– Here you will find examples of many different types of home composting bins that you can use to make quality compost in your own backyard. There’s information about each of these, as well as flyers on how to compost at home. It can help you decide which composter will work best for you.\n" +
                "\n" +
                "If you would like to become a part of the Home Demonstration Program, please call 503-874-8260 and speak to the Horticulture Manager.";
        gardenTextBodiesArray[8] = "The Honor Garden is dedicated to the 165 donors whose generous spirit helped build The Oregon Garden during its formative years, 1993 to 2002. Recognition is given to Art Anderson, who was the first Oregon Garden Board president (1994-98), and Clayton Hannon, the first executive director (1994-97), both of whom deserve credit for leading this great effort. Names of all the contributing individuals, foundations, nurseries, corporations, membership organizations and government agencies are displayed on eight cedar totem poles.\n" +
                "\n" +
                "Plants of Interest: Rhododendron, American Aloe Century Plant, and Burning Bush.\n";
        gardenTextBodiesArray[9] = "The Lewis and Clark Garden is a living museum of the many botanical finds Meriwether Lewis and William Clark documented on their Corps of Discovery’s journey more than 200 years ago. The Lewis & Clark Garden is situated near the Oak Grove and the Rediscovery Forest in the southern part of The Oregon Garden grounds. Onsite educational materials include interpretive signs and plant labels. The significance of the plants to Northwest tribes and the Corps of Discovery are highlighted. Travel through the diverse regions of the Pacific Northwest as Lewis and Clark did: sit at their campsite along the rushing stream, look out over the dry steppes of the Columbia Plateau, and say goodbye to the lush forest of the Pacific Coast before journeying home.\n" +
                "\n" +
                "Plants of Interest: Ponderosa Pines, Vine Maples, and Salmonberry bushes in this garden are great examples of the diversity of plants the Northwest has to offer.";
        gardenTextBodiesArray[10] = "The Medicinal Garden displays many different varieties of medicinal plant species that are commonly grown here in our climate. Each plant has, or was believed to have, medicinal properties when properly prepared. This garden is located next to the Proven Winners Display & Trial Garden.\n" +
                "\n" +
                "Plants of Interest: Rosemary, Wall Germander, Lavender, Oregano, and Coneflower can be found in this garden and are all different types of plants that can be used to treat ailments of the body.\n";
        gardenTextBodiesArray[11] = "The Northwest Garden img046 Garden’s landscape design showcases plants and trees that thrive in our region. Visitors experience meandering pathways through lush garden beds filled with color, texture, form and movement. Highlights include a large pergola covered in vines and an area created in partnership with Monrovia nursery. This was one of our first completed gardens and is an excellent place to spend some time if you are looking for ideas in your own Northwest landscape.";
        gardenTextBodiesArray[12] = "A spectacular 25-acre native oak grove lives in the Garden and is home to FullSizeRender (7)many trees more than 100 years old. The 100-foot-high Signature Oak is 400 years old and its massive branches touch the ground in several places. It has been designated as one of Oregon’s 'Heritage Trees'.\n" +
                "The first white oak took root an estimated 400 years ago, and now the grove’s under story is being returned to its original pristine condition, as the Himalayan blackberry and other non-native species are being removed.";
        gardenTextBodiesArray[13] = "We love animals! Yes, we do! Bring Fido, and let him check out the Pet Friendly Garden, which educates visitors to The Oregon Garden as to which plants are friendly and which are toxic to pets. The Pet Friendly Garden is on the north side of the Chez Garden. The space provided, although not large, addresses the issues of creating a landscape that accommodates pets.\n" +
                "\n" +
                "We do require that pets be kept on leashes 8 feet in length or shorter and under your control at all times. Please pick up after your pet, and remember that although we love our animals, not everyone else does. Your well-mannered companion is sure to enjoy exploring the Garden with you.";
        gardenTextBodiesArray[14] = "Proven Winners is the leading brand of high quality flowering plants in North America, which are available from just about every garden center in North America. Proven Winners’s goal is to introduce the best, most unique, high performing plants, to produce them under the highest quality standards, and to market the plants innovatively.\n" +
                "\n" +
                "Their rigorous plant selection process takes 2-3 years and occurs at facilities in the U.S. and Canada, as well as at trial stations in Europe, South Africa, and Japan. One of those facilities being The Oregon Garden. Every Proven Winners variety is protected by U.S. and Canadian patents. The Proven Winners trial garden and display is a part of that process. The Oregon Garden is working with Proven Winners to evaluate plants so that only the best are brought to you for your home.\n" +
                "\n" +
                "Location: The Proven Winners Display and Trial Garden is located at the North end of the Home Demonstration gardens, where the tram path bends towards the Pavilion.\n" +
                "\n" +
                "Help Proven Winners and The Oregon Garden\n" +
                "You can help us and Proven Winners by completing our guest survey about the Proven Winners Display and Test Garden. The information you provide will help Proven Winners create the best possible product. Guest surveys can be obtained from the Visitor Center as you enter the Garden.\n";
        gardenTextBodiesArray[15] = "The Oregon Garden’s Rediscovery Forest offers a peaceful respite in the shade of Douglas-firs and singing birds. This demonstration forest, managed in partnership with the Oregon Forest Resources Institute (OFRI) serves the multiple goals of education, research and public enjoyment.\n" +
                "\n" +
                "Hike the different trails through this dynamic demonstration forest. You will learn about reforestation, forest management, seed tree forests, growing Christmas trees, and hardwood forest management through the interpretive signage placed along easily-accessible trails.\n" +
                "\n" +
                "Forestry Education\n" +
                "The Rediscovery Forest Education Programs provide K-12 students an opportunity to discover the importance of Oregon’s forests, see forest management and understand how forests contribute to our quality of life.\n" +
                " \n" +
                "Events\n" +
                "A large clearing in the forest is perfect for your upcoming events. We would love to help you plan your next family reunion or company picnic in the Rediscovery Forest.\n";
        gardenTextBodiesArray[16] = "Adjacent to the Garden Green, the Rose Garden features nearly 40 rose varieties, including The Oregon Garden rose. The beds are laid out by color from pale yellow to pink to deep red. Stone paths, arbors and benches for sitting back to relax while taking in the amazing scents accent the garden. It serves as a delightful backdrop for the many events that take place on the Garden Green.";
        gardenTextBodiesArray[17] = "The Rose Petal Fountain is located above the Garden Green and below the Bosque. It features a cascade of water, up to 30 feet in height, surrounded by a spectacular collection of annuals. The highlight of this location is the expansive view of the Willamette Valley. This garden goes through dramatic changes throughout the year. During the summer the plants around the fountain often get to be so tall that only the arcs of the water can be seen from outside the surrounding area. This fountain is a popular spot on hot summer days and is also a great place to document your visit to The Garden with a photo.";
        gardenTextBodiesArray[18] = "The Sensory Garden is a therapeutic garden that features reArbor in Sensory Gardenmarkable scents and textures that exercise the imagination. It includes an in-ground compass, a large wood trellis of Port Orford cedar, and a beautiful rain curtain, 20 feet long and eight feet high. The garden creates an environment for the physically challenged to experience and enjoy nature close up. Located near the Visitor Center, adjacent to the stairway leading to the J. Frank Schmidt Jr. Pavilion. Financial support was provided by Conrad and Murial Stieber with additional assistance by the Oregon Pythians.";
        gardenTextBodiesArray[19] = "Agricultural products grown in the Willamette Valley are showcased in the Silverton Market Garden. Many of the 147 Oregon crops are represented, including berries, grapes, other fruits, grass seed, hops and assorted vegetables. A rill filled with water runs through the center of this garden and ends in a small waterfall, symbolizing nearby Silver Falls. As a connection to the nearby Children’s Garden, there are a series of raised vegetable beds and a working, old-fashioned water pump where visitors are encouraged to do some hands-on gardening. Produce from this garden is donated to families in need; in 2008, more than 7,000 pounds of produce was harvested from the Market Garden.";
        gardenTextBodiesArray[20] = "Adjacent to the Children’s Garden, the Train Garden is a must see for everyone young or old.Train Garden\n" +
                "\n" +
                "The train is roughly 1/20th the size of an early 1970’s Southern Pacific train that once ran through Silverton and neighboring towns throughout the Willamette Valley. The feature consists of 120 feet of circular track, looping the 1970’s Southern Pacific diesel style engine complete with two box cars, two flat cars and a caboose, around a mountain and through hedges.  Dwarf conifers and other small plants are set in place along the route, their size and species intentionally coordinated with the train’s G-scale proportions. The goal is to show how to use limited garden space and appeal to children.\n" +
                "\n" +
                "The Oregon Garden’s horticultural team designed the vegetation and plantings for this innovative exhibit, while the Pacific Crossings Railroad Club of Salem and the Rose City Garden Railway Society of Portland donated funds to purchase the train and accessories, and designed the layout.  The project took about a year and a half to complete and has become a favorite feature for kids of all ages, most of whom can’t resist waiting for the train to toot its way out of the arborvitae tunnel emblazoned with an iconic golden spike.\n" +
                "\n" +
                "Powered by a low-voltage electric track, all the train’s components are weather safe, and it is generally in operation between 10 am and 3 pm daily.\n" +
                "\n" +
                "If you’re interested in supporting the ";
        gardenTextBodiesArray[21] = "Adjacent to the Pavilion The Tropical House features many plants people have seen while on vacation in warmer climates, including hibiscus, oleander, mandavilla, orchids and bananas, just to name a few. Because these plants are from tropical and subtropical regions, the environment is kept warm and humid.";
        gardenTextBodiesArray[22] = "The Weltands are an innovative, pioneering program in partnership with the City of Silverton in which the area’s treated waste water is used to create a thriving wetlands habitat for a variety of wildlife and plants.\n" +
                "\n" +
                "The water travels at the rate of 300 gallons per minute in peak season through a series of terraced ponds with cascading water, pools and wetlands plants, into a holding tank where it then flows into an irrigation system — a unique and attractive method of using treated water to irrigate the Garden. The Wetlands also play an active role in the education programs at the Garden.";


        gardenInfo = new ArrayList();
        for (int i = 0; i < gardenTitlesArray.length; i++) {
            GardenData data = new GardenData(gardenTitlesArray[i], gardenPhotosArray[i], gardenThumbnailsArray[i], gardenCreatorsArray[i], gardenTextBodiesArray[i]);
            gardenInfo.add(data);
        }

    }

    public ArrayList<GardenData> getGardenDataList() {

        return gardenInfo;
    }
}