package com.jorgegiance.folks.util;

import com.jorgegiance.folks.models.firebaseModels.Item;

import java.util.ArrayList;

public class DummyDB {


//    public static ArrayList<Item> getHomeItemList(){
//
//        ArrayList<News> newsList2 = new ArrayList<>();
//        ArrayList<News> newsList3 = new ArrayList<>();
//        ArrayList<News> newsList4 = new ArrayList<>();
//        ArrayList<News> newsList5 = new ArrayList<>();
//        ArrayList<Item> itemsList = new ArrayList<>();
//
//        News news1 = new News(
//                "Biden to discuss sexual assault claim, network says, as President Trump says it could be a ‘false accusation’",
//                "The Washington Post",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Ac auctor augue mauris augue neque gravida in fermentum et. Semper quis lectus nulla at. Commodo quis imperdiet massa tincidunt nunc pulvinar sapien. Rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque. Quis blandit turpis cursus in hac habitasse platea. A pellentesque sit amet porttitor eget dolor morbi non. Velit egestas dui id ornare arcu. Mattis nunc sed blandit libero volutpat sed cras ornare. Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper. Mauris nunc congue nisi vitae. Phasellus faucibus scelerisque eleifend donec pretium. Amet consectetur adipiscing elit duis tristique sollicitudin.\n" +
//                        "\n" +
//                        "Nunc pulvinar sapien et ligula ullamcorper. Habitant morbi tristique senectus et. Blandit massa enim nec dui nunc mattis enim ut tellus. Quis eleifend quam adipiscing vitae proin sagittis. Tellus elementum sagittis vitae et leo duis ut diam quam. Et egestas quis ipsum suspendisse ultrices. Ullamcorper eget nulla facilisi etiam dignissim diam quis enim lobortis. Fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Aliquet porttitor lacus luctus accumsan. Eu ultrices vitae auctor eu augue.\n" +
//                        "\n" +
//                        "Ac odio tempor orci dapibus ultrices. Purus gravida quis blandit turpis. Orci porta non pulvinar neque laoreet suspendisse interdum. Sollicitudin tempor id eu nisl nunc mi ipsum. Faucibus pulvinar elementum integer enim neque volutpat. Senectus et netus et malesuada fames ac turpis egestas. Pretium viverra suspendisse potenti nullam ac tortor vitae. Lobortis feugiat vivamus at augue eget. Aliquet nec ullamcorper sit amet risus nullam eget felis. Elit scelerisque mauris pellentesque pulvinar. Euismod nisi porta lorem mollis aliquam ut porttitor leo. Id semper risus in hendrerit gravida rutrum quisque non tellus. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Metus aliquam eleifend mi in nulla posuere sollicitudin. Cras tincidunt lobortis feugiat vivamus at. Ipsum consequat nisl vel pretium lectus quam. Aliquam vestibulum morbi blandit cursus risus at ultrices mi. Ut tristique et egestas quis ipsum suspendisse ultrices.\n" +
//                        "\n" +
//                        "Et magnis dis parturient montes nascetur ridiculus mus. Porttitor eget dolor morbi non arcu risus. Ipsum a arcu cursus vitae congue mauris rhoncus. Interdum velit euismod in pellentesque massa placerat. Accumsan tortor posuere ac ut consequat semper viverra. Aliquam etiam erat velit scelerisque in dictum non. Sodales ut eu sem integer vitae justo. Amet consectetur adipiscing elit pellentesque habitant. Condimentum id venenatis a condimentum vitae sapien pellentesque. Aliquet nibh praesent tristique magna. Pellentesque massa placerat duis ultricies lacus sed turpis. A cras semper auctor neque vitae tempus. Massa tincidunt dui ut ornare lectus sit amet est. Mauris augue neque gravida in fermentum et. Dignissim suspendisse in est ante in nibh mauris cursus mattis. Varius vel pharetra vel turpis nunc eget lorem dolor.\n" +
//                        "\n" +
//                        "Pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus et. Quis vel eros donec ac. Eget dolor morbi non arcu risus quis varius quam. Adipiscing elit pellentesque habitant morbi tristique. Nulla at volutpat diam ut venenatis tellus in metus. Amet dictum sit amet justo. Nisi lacus sed viverra tellus in hac habitasse platea dictumst. Adipiscing elit pellentesque habitant morbi tristique senectus et netus et. Mauris a diam maecenas sed enim ut sem. Proin libero nunc consequat interdum varius sit amet mattis vulputate. Parturient montes nascetur ridiculus mus mauris vitae ultricies. Ut morbi tincidunt augue interdum velit euismod.",
//                System.currentTimeMillis(),
//                "https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/ZTV2U7ULFYI6VHP5TEHZ3TDR7Q.jpg&w=767",
//                null
//        );
//
//        News news2 = new News(
//                "Trump calls newly released UFO footage 'a hell of a video'",
//                "CNN",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Ac auctor augue mauris augue neque gravida in fermentum et. Semper quis lectus nulla at. Commodo quis imperdiet massa tincidunt nunc pulvinar sapien. Rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque. Quis blandit turpis cursus in hac habitasse platea. A pellentesque sit amet porttitor eget dolor morbi non. Velit egestas dui id ornare arcu. Mattis nunc sed blandit libero volutpat sed cras ornare. Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper. Mauris nunc congue nisi vitae. Phasellus faucibus scelerisque eleifend donec pretium. Amet consectetur adipiscing elit duis tristique sollicitudin.\n" +
//                        "\n" +
//                        "Nunc pulvinar sapien et ligula ullamcorper. Habitant morbi tristique senectus et. Blandit massa enim nec dui nunc mattis enim ut tellus. Quis eleifend quam adipiscing vitae proin sagittis. Tellus elementum sagittis vitae et leo duis ut diam quam. Et egestas quis ipsum suspendisse ultrices. Ullamcorper eget nulla facilisi etiam dignissim diam quis enim lobortis. Fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Aliquet porttitor lacus luctus accumsan. Eu ultrices vitae auctor eu augue.\n" +
//                        "\n" +
//                        "Ac odio tempor orci dapibus ultrices. Purus gravida quis blandit turpis. Orci porta non pulvinar neque laoreet suspendisse interdum. Sollicitudin tempor id eu nisl nunc mi ipsum. Faucibus pulvinar elementum integer enim neque volutpat. Senectus et netus et malesuada fames ac turpis egestas. Pretium viverra suspendisse potenti nullam ac tortor vitae. Lobortis feugiat vivamus at augue eget. Aliquet nec ullamcorper sit amet risus nullam eget felis. Elit scelerisque mauris pellentesque pulvinar. Euismod nisi porta lorem mollis aliquam ut porttitor leo. Id semper risus in hendrerit gravida rutrum quisque non tellus. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Metus aliquam eleifend mi in nulla posuere sollicitudin. Cras tincidunt lobortis feugiat vivamus at. Ipsum consequat nisl vel pretium lectus quam. Aliquam vestibulum morbi blandit cursus risus at ultrices mi. Ut tristique et egestas quis ipsum suspendisse ultrices.\n" +
//                        "\n" +
//                        "Et magnis dis parturient montes nascetur ridiculus mus. Porttitor eget dolor morbi non arcu risus. Ipsum a arcu cursus vitae congue mauris rhoncus. Interdum velit euismod in pellentesque massa placerat. Accumsan tortor posuere ac ut consequat semper viverra. Aliquam etiam erat velit scelerisque in dictum non. Sodales ut eu sem integer vitae justo. Amet consectetur adipiscing elit pellentesque habitant. Condimentum id venenatis a condimentum vitae sapien pellentesque. Aliquet nibh praesent tristique magna. Pellentesque massa placerat duis ultricies lacus sed turpis. A cras semper auctor neque vitae tempus. Massa tincidunt dui ut ornare lectus sit amet est. Mauris augue neque gravida in fermentum et. Dignissim suspendisse in est ante in nibh mauris cursus mattis. Varius vel pharetra vel turpis nunc eget lorem dolor.\n" +
//                        "\n" +
//                        "Pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus et. Quis vel eros donec ac. Eget dolor morbi non arcu risus quis varius quam. Adipiscing elit pellentesque habitant morbi tristique. Nulla at volutpat diam ut venenatis tellus in metus. Amet dictum sit amet justo. Nisi lacus sed viverra tellus in hac habitasse platea dictumst. Adipiscing elit pellentesque habitant morbi tristique senectus et netus et. Mauris a diam maecenas sed enim ut sem. Proin libero nunc consequat interdum varius sit amet mattis vulputate. Parturient montes nascetur ridiculus mus mauris vitae ultricies. Ut morbi tincidunt augue interdum velit euismod.",
//                System.currentTimeMillis(),
//                "https://amd-ssl.cdn.turner.com/cnn/big/ads/2020/04/30/CoronaVirusFactsAndFears_TownHall_Number9_BillGates_Rev_Tonight_8p_15_C4JJ4_576x324.mp4",
//                "https://amd-ssl.cdn.turner.com/cnn/big/ads/2020/04/30/CoronaVirusFactsAndFears_TownHall_Number9_BillGates_Rev_Tonight_8p_15_C4JJ4_576x324.mp4"
//        );
//
//        News news3 = new News(
//                "House Democrats push to include primary care workers in coronavirus relief package",
//                "The Hill",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Ac auctor augue mauris augue neque gravida in fermentum et. Semper quis lectus nulla at. Commodo quis imperdiet massa tincidunt nunc pulvinar sapien. Rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque. Quis blandit turpis cursus in hac habitasse platea. A pellentesque sit amet porttitor eget dolor morbi non. Velit egestas dui id ornare arcu. Mattis nunc sed blandit libero volutpat sed cras ornare. Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper. Mauris nunc congue nisi vitae. Phasellus faucibus scelerisque eleifend donec pretium. Amet consectetur adipiscing elit duis tristique sollicitudin.\n" +
//                        "\n" +
//                        "Nunc pulvinar sapien et ligula ullamcorper. Habitant morbi tristique senectus et. Blandit massa enim nec dui nunc mattis enim ut tellus. Quis eleifend quam adipiscing vitae proin sagittis. Tellus elementum sagittis vitae et leo duis ut diam quam. Et egestas quis ipsum suspendisse ultrices. Ullamcorper eget nulla facilisi etiam dignissim diam quis enim lobortis. Fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Aliquet porttitor lacus luctus accumsan. Eu ultrices vitae auctor eu augue.\n" +
//                        "\n" +
//                        "Ac odio tempor orci dapibus ultrices. Purus gravida quis blandit turpis. Orci porta non pulvinar neque laoreet suspendisse interdum. Sollicitudin tempor id eu nisl nunc mi ipsum. Faucibus pulvinar elementum integer enim neque volutpat. Senectus et netus et malesuada fames ac turpis egestas. Pretium viverra suspendisse potenti nullam ac tortor vitae. Lobortis feugiat vivamus at augue eget. Aliquet nec ullamcorper sit amet risus nullam eget felis. Elit scelerisque mauris pellentesque pulvinar. Euismod nisi porta lorem mollis aliquam ut porttitor leo. Id semper risus in hendrerit gravida rutrum quisque non tellus. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Metus aliquam eleifend mi in nulla posuere sollicitudin. Cras tincidunt lobortis feugiat vivamus at. Ipsum consequat nisl vel pretium lectus quam. Aliquam vestibulum morbi blandit cursus risus at ultrices mi. Ut tristique et egestas quis ipsum suspendisse ultrices.\n" +
//                        "\n" +
//                        "Et magnis dis parturient montes nascetur ridiculus mus. Porttitor eget dolor morbi non arcu risus. Ipsum a arcu cursus vitae congue mauris rhoncus. Interdum velit euismod in pellentesque massa placerat. Accumsan tortor posuere ac ut consequat semper viverra. Aliquam etiam erat velit scelerisque in dictum non. Sodales ut eu sem integer vitae justo. Amet consectetur adipiscing elit pellentesque habitant. Condimentum id venenatis a condimentum vitae sapien pellentesque. Aliquet nibh praesent tristique magna. Pellentesque massa placerat duis ultricies lacus sed turpis. A cras semper auctor neque vitae tempus. Massa tincidunt dui ut ornare lectus sit amet est. Mauris augue neque gravida in fermentum et. Dignissim suspendisse in est ante in nibh mauris cursus mattis. Varius vel pharetra vel turpis nunc eget lorem dolor.\n" +
//                        "\n" +
//                        "Pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus et. Quis vel eros donec ac. Eget dolor morbi non arcu risus quis varius quam. Adipiscing elit pellentesque habitant morbi tristique. Nulla at volutpat diam ut venenatis tellus in metus. Amet dictum sit amet justo. Nisi lacus sed viverra tellus in hac habitasse platea dictumst. Adipiscing elit pellentesque habitant morbi tristique senectus et netus et. Mauris a diam maecenas sed enim ut sem. Proin libero nunc consequat interdum varius sit amet mattis vulputate. Parturient montes nascetur ridiculus mus mauris vitae ultricies. Ut morbi tincidunt augue interdum velit euismod.",
//                System.currentTimeMillis(),
//                "https://thehill.com/sites/default/files/styles/thumb_small_article/public/castrojoaquin_111219gn2_lead.jpg?itok=yg96tJXi",
//                null
//        );
//
//        News news4 = new News(
//                "House Democrats push to include primary care workers in coronavirus relief package",
//                "The Hill",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Ac auctor augue mauris augue neque gravida in fermentum et. Semper quis lectus nulla at. Commodo quis imperdiet massa tincidunt nunc pulvinar sapien. Rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque. Quis blandit turpis cursus in hac habitasse platea. A pellentesque sit amet porttitor eget dolor morbi non. Velit egestas dui id ornare arcu. Mattis nunc sed blandit libero volutpat sed cras ornare. Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper. Mauris nunc congue nisi vitae. Phasellus faucibus scelerisque eleifend donec pretium. Amet consectetur adipiscing elit duis tristique sollicitudin.\n" +
//                        "\n" +
//                        "Nunc pulvinar sapien et ligula ullamcorper. Habitant morbi tristique senectus et. Blandit massa enim nec dui nunc mattis enim ut tellus. Quis eleifend quam adipiscing vitae proin sagittis. Tellus elementum sagittis vitae et leo duis ut diam quam. Et egestas quis ipsum suspendisse ultrices. Ullamcorper eget nulla facilisi etiam dignissim diam quis enim lobortis. Fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Aliquet porttitor lacus luctus accumsan. Eu ultrices vitae auctor eu augue.\n" +
//                        "\n" +
//                        "Ac odio tempor orci dapibus ultrices. Purus gravida quis blandit turpis. Orci porta non pulvinar neque laoreet suspendisse interdum. Sollicitudin tempor id eu nisl nunc mi ipsum. Faucibus pulvinar elementum integer enim neque volutpat. Senectus et netus et malesuada fames ac turpis egestas. Pretium viverra suspendisse potenti nullam ac tortor vitae. Lobortis feugiat vivamus at augue eget. Aliquet nec ullamcorper sit amet risus nullam eget felis. Elit scelerisque mauris pellentesque pulvinar. Euismod nisi porta lorem mollis aliquam ut porttitor leo. Id semper risus in hendrerit gravida rutrum quisque non tellus. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Metus aliquam eleifend mi in nulla posuere sollicitudin. Cras tincidunt lobortis feugiat vivamus at. Ipsum consequat nisl vel pretium lectus quam. Aliquam vestibulum morbi blandit cursus risus at ultrices mi. Ut tristique et egestas quis ipsum suspendisse ultrices.\n" +
//                        "\n" +
//                        "Et magnis dis parturient montes nascetur ridiculus mus. Porttitor eget dolor morbi non arcu risus. Ipsum a arcu cursus vitae congue mauris rhoncus. Interdum velit euismod in pellentesque massa placerat. Accumsan tortor posuere ac ut consequat semper viverra. Aliquam etiam erat velit scelerisque in dictum non. Sodales ut eu sem integer vitae justo. Amet consectetur adipiscing elit pellentesque habitant. Condimentum id venenatis a condimentum vitae sapien pellentesque. Aliquet nibh praesent tristique magna. Pellentesque massa placerat duis ultricies lacus sed turpis. A cras semper auctor neque vitae tempus. Massa tincidunt dui ut ornare lectus sit amet est. Mauris augue neque gravida in fermentum et. Dignissim suspendisse in est ante in nibh mauris cursus mattis. Varius vel pharetra vel turpis nunc eget lorem dolor.\n" +
//                        "\n" +
//                        "Pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus et. Quis vel eros donec ac. Eget dolor morbi non arcu risus quis varius quam. Adipiscing elit pellentesque habitant morbi tristique. Nulla at volutpat diam ut venenatis tellus in metus. Amet dictum sit amet justo. Nisi lacus sed viverra tellus in hac habitasse platea dictumst. Adipiscing elit pellentesque habitant morbi tristique senectus et netus et. Mauris a diam maecenas sed enim ut sem. Proin libero nunc consequat interdum varius sit amet mattis vulputate. Parturient montes nascetur ridiculus mus mauris vitae ultricies. Ut morbi tincidunt augue interdum velit euismod.",
//                System.currentTimeMillis(),
//                "https://thehill.com/sites/default/files/styles/thumb_small_article/public/castrojoaquin_111219gn2_lead.jpg?itok=yg96tJXi",
//                null
//        );
//
//        News news5 = new News(
//                "House Democrats push to include primary care workers in coronavirus relief package",
//                "The Hill",
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Ac auctor augue mauris augue neque gravida in fermentum et. Semper quis lectus nulla at. Commodo quis imperdiet massa tincidunt nunc pulvinar sapien. Rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar pellentesque. Quis blandit turpis cursus in hac habitasse platea. A pellentesque sit amet porttitor eget dolor morbi non. Velit egestas dui id ornare arcu. Mattis nunc sed blandit libero volutpat sed cras ornare. Ac feugiat sed lectus vestibulum mattis ullamcorper velit sed ullamcorper. Mauris nunc congue nisi vitae. Phasellus faucibus scelerisque eleifend donec pretium. Amet consectetur adipiscing elit duis tristique sollicitudin.\n" +
//                        "\n" +
//                        "Nunc pulvinar sapien et ligula ullamcorper. Habitant morbi tristique senectus et. Blandit massa enim nec dui nunc mattis enim ut tellus. Quis eleifend quam adipiscing vitae proin sagittis. Tellus elementum sagittis vitae et leo duis ut diam quam. Et egestas quis ipsum suspendisse ultrices. Ullamcorper eget nulla facilisi etiam dignissim diam quis enim lobortis. Fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate. Aliquet porttitor lacus luctus accumsan. Eu ultrices vitae auctor eu augue.\n" +
//                        "\n" +
//                        "Ac odio tempor orci dapibus ultrices. Purus gravida quis blandit turpis. Orci porta non pulvinar neque laoreet suspendisse interdum. Sollicitudin tempor id eu nisl nunc mi ipsum. Faucibus pulvinar elementum integer enim neque volutpat. Senectus et netus et malesuada fames ac turpis egestas. Pretium viverra suspendisse potenti nullam ac tortor vitae. Lobortis feugiat vivamus at augue eget. Aliquet nec ullamcorper sit amet risus nullam eget felis. Elit scelerisque mauris pellentesque pulvinar. Euismod nisi porta lorem mollis aliquam ut porttitor leo. Id semper risus in hendrerit gravida rutrum quisque non tellus. Commodo sed egestas egestas fringilla phasellus faucibus scelerisque eleifend. Metus aliquam eleifend mi in nulla posuere sollicitudin. Cras tincidunt lobortis feugiat vivamus at. Ipsum consequat nisl vel pretium lectus quam. Aliquam vestibulum morbi blandit cursus risus at ultrices mi. Ut tristique et egestas quis ipsum suspendisse ultrices.\n" +
//                        "\n" +
//                        "Et magnis dis parturient montes nascetur ridiculus mus. Porttitor eget dolor morbi non arcu risus. Ipsum a arcu cursus vitae congue mauris rhoncus. Interdum velit euismod in pellentesque massa placerat. Accumsan tortor posuere ac ut consequat semper viverra. Aliquam etiam erat velit scelerisque in dictum non. Sodales ut eu sem integer vitae justo. Amet consectetur adipiscing elit pellentesque habitant. Condimentum id venenatis a condimentum vitae sapien pellentesque. Aliquet nibh praesent tristique magna. Pellentesque massa placerat duis ultricies lacus sed turpis. A cras semper auctor neque vitae tempus. Massa tincidunt dui ut ornare lectus sit amet est. Mauris augue neque gravida in fermentum et. Dignissim suspendisse in est ante in nibh mauris cursus mattis. Varius vel pharetra vel turpis nunc eget lorem dolor.\n" +
//                        "\n" +
//                        "Pellentesque pulvinar pellentesque habitant morbi tristique senectus et netus et. Quis vel eros donec ac. Eget dolor morbi non arcu risus quis varius quam. Adipiscing elit pellentesque habitant morbi tristique. Nulla at volutpat diam ut venenatis tellus in metus. Amet dictum sit amet justo. Nisi lacus sed viverra tellus in hac habitasse platea dictumst. Adipiscing elit pellentesque habitant morbi tristique senectus et netus et. Mauris a diam maecenas sed enim ut sem. Proin libero nunc consequat interdum varius sit amet mattis vulputate. Parturient montes nascetur ridiculus mus mauris vitae ultricies. Ut morbi tincidunt augue interdum velit euismod.",
//                System.currentTimeMillis(),
//                "https://thehill.com/sites/default/files/styles/thumb_small_article/public/castrojoaquin_111219gn2_lead.jpg?itok=yg96tJXi",
//                null
//        );
//
//
//        newsList2.add(news1);
//        newsList3.add(news3);
//        newsList3.add(news3);
//        newsList4.add(news2);
//
//        Item item1 = new HomeItem(
//                null,
//                null,
//                "COVID-19 updates: a map of the virus spread in the U.S., plus what your next hotel stay could look like."
//        );
//
//        Item item2 = new HomeItem(
//                newsList2,
//                "Politics",
//                null
//        );
//
//        Item item3 = new HomeItem(
//                newsList3,
//                null,
//                null
//        );
//        Item item4 = new HomeItem(
//                newsList4,
//                null,
//                null
//        );
//        Item item5 = new HomeItem(
//                newsList2,
//                null,
//                null
//        );
//
//        itemsList.add(item1);
//        itemsList.add(item2);
//        itemsList.add(item3);
//        itemsList.add(item4);
//        itemsList.add(item5);
//        itemsList.add(item1);
//        itemsList.add(item2);
//        itemsList.add(item3);
//        itemsList.add(item4);
//        itemsList.add(item5);
//        itemsList.add(item1);
//        itemsList.add(item2);
//        itemsList.add(item3);
//        itemsList.add(item4);
//        itemsList.add(item5);
//
//        return itemsList;
//
//    }







}
